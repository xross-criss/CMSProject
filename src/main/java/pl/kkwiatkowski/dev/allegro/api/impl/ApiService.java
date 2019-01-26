package pl.kkwiatkowski.dev.allegro.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kkwiatkowski.dev.allegro.api.dao.Item;
import pl.kkwiatkowski.dev.allegro.api.dao.OfferList;
import pl.kkwiatkowski.dev.allegro.api.dao.OfferListResponse;
import pl.kkwiatkowski.dev.allegro.api.exceptions.AuthorizationException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pl.kkwiatkowski.dev.allegro.api.constants.Constants.*;

@Slf4j
@Service
public class ApiService {

    private RestTemplate restTemplate;

    public OfferListResponse searchForItems(String searchPhrase) throws IOException {
        return getListnings(searchPhrase);
    }

    private OfferListResponse getListnings(String searchPhrase) throws IOException {
        checkForAccessToken();

        StringBuilder sb = new StringBuilder(GET_LISTING_URL);
        sb.append("?category.id=" + CATEGORY_ID + "&searchMode=REGULAR" + "&phrase=" + searchPhrase);

        OfferList offerList = callForListnings(sb);

        /*List<Item> promotedList = offerList.getItems().getPromoted().stream()
                .filter(item ->
                        (item.getSellingMode().getFormat().equals("BUY_NOW")) &&
                                (item.getImages().getUrl() != null)
                ).collect(Collectors.toList());

        List<Item> regularList = offerList.getItems().getRegular().stream()
                .filter(item ->
                        (item.getSellingMode().getFormat().equals("BUY_NOW")) &&
                                (item.getImages().getUrl() != null)
                ).collect(Collectors.toList());

        List<Item> finalList = new ArrayList<>();

        if (promotedList.size() != PROMOTED_OFFERS_VALUE) {
            finalList.addAll(chooseRandomOffers(promotedList, PROMOTED_OFFERS_VALUE));
        }
        if (regularList.size() != REGULAR_OFFERS_VALUE) {
            finalList.addAll(chooseRandomOffers(regularList, REGULAR_OFFERS_VALUE));
        }*/

        List<Item> finalList = new ArrayList<>();
        finalList.addAll(chooseRandomOffers(offerList.getItems().getPromoted(), PROMOTED_OFFERS_VALUE));
        finalList.addAll(chooseRandomOffers(offerList.getItems().getRegular(), REGULAR_OFFERS_VALUE));

        OfferListResponse response = new OfferListResponse();
        response.setOffersList(finalList);

        return response;
    }

    private List<Item> chooseRandomOffers(List<Item> promotedList, int value) {
        if (value == 0) {
            try {
                throw new Exception("Value cannot be zero of choosing offers");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Item> choosedOffers = new ArrayList<>();

        for (int i = 0; i < value; i++) {
            choosedOffers.add(promotedList.get((int) (Math.random() * (promotedList.size() + 1)) + 1));
        }

        return choosedOffers;
    }

    private OfferList callForListnings(StringBuilder sb) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", ALLEGRO_JSON_TYPE);
        headers.set("Accept", ALLEGRO_JSON_TYPE);
        headers.set("Authorization", "Bearer " + ACCESS_TOKEN);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = callForGET(sb.toString(), entity);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.getBody(), OfferList.class);
    }

    private ResponseEntity<String> callForGET(String url, HttpEntity entity) {
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new AuthorizationException();
        }

        return response;
    }

    private void checkForAccessToken() {
        if (AUTHORIZED_LOCALDATETIME == null) {
            authorizeToAllegroApi();
        }

        LocalDate localDate = AUTHORIZED_LOCALDATETIME.toLocalDate();
        LocalTime localTime = AUTHORIZED_LOCALDATETIME.toLocalTime();

        if (!LocalDate.now().isEqual(localDate) && LocalTime.now().compareTo(localTime) > LocalTime.of(11, 59).toSecondOfDay()) {
            authorizeToAllegroApi();
        }
    }

    private void authorizeToAllegroApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + AUTHORIZATION_CREDENTIALS);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = callForGET(AUTHORIZATION_URL, entity);
        ObjectMapper objectMapper = new ObjectMapper();

        AUTHORIZED_LOCALDATETIME = LocalDateTime.now();
        try {
            ACCESS_TOKEN = objectMapper.readTree(response.getBody()).asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}