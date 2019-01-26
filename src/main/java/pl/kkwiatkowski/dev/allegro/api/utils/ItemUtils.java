package pl.kkwiatkowski.dev.allegro.api.utils;

import lombok.NoArgsConstructor;
import pl.kkwiatkowski.dev.allegro.api.dao.Item;
import pl.kkwiatkowski.dev.allegro.api.dao.ResponseItem;

import java.util.List;
import java.util.stream.Collectors;

import static pl.kkwiatkowski.dev.allegro.api.constants.Constants.OFFERS_URL;

@NoArgsConstructor
public class ItemUtils {

    public static List<ResponseItem> convertToResponseList(List<Item> itemList) {
        return itemList.stream().map(ItemUtils::convertToResponseItem).collect(Collectors.toList());
    }

    private static ResponseItem convertToResponseItem(Item item) {
        ResponseItem responseItem = new ResponseItem();
        responseItem.setOfferId(item.getId());
        responseItem.setOfferName(item.getName());
        responseItem.setOfferPrice(item.getSellingMode().getPrice().getAmount().toString());
        responseItem.setOfferURL(OFFERS_URL + item.getId());
        responseItem.setImageURL(item.getImages().get(0).getUrl());

        return responseItem;
    }
}
