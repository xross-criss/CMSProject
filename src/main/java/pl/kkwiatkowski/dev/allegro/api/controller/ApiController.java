package pl.kkwiatkowski.dev.allegro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kkwiatkowski.dev.allegro.api.dao.OfferList;
import pl.kkwiatkowski.dev.allegro.api.impl.ApiService;

import java.io.IOException;

@RestController
@RequestMapping("/allegro/api/")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/search_for_products/{searchPhrase}")
    public OfferList applyForLoan(@PathVariable String searchPhrase) throws IOException {
        return apiService.searchForItems(searchPhrase);
    }
}