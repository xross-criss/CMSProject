package pl.kkwiatkowski.dev.allegro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kkwiatkowski.dev.allegro.api.dao.ItemRequest;
import pl.kkwiatkowski.dev.allegro.api.dao.OfferListResponse;
import pl.kkwiatkowski.dev.allegro.api.impl.ApiService;

import java.io.IOException;

@RestController
@RequestMapping("/allegro/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    OfferListResponse searchForProducts(@RequestBody ItemRequest request) throws IOException {
        return apiService.searchForItems(request.getRequest());
    }
}