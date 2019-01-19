package pl.kkwiatkowski.dev.allegro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kkwiatkowski.dev.allegro.api.dao.OfferListResponse;
import pl.kkwiatkowski.dev.allegro.api.impl.ApiService;

import java.io.IOException;

@RestController
@RequestMapping("/allegro/api/")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/search_for_products/{searchPhrase}")
    public OfferListResponse applyForLoan(@PathVariable String searchPhrase) throws IOException {
        return apiService.searchForItems(searchPhrase);
    }
}