package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.*;

import java.util.List;

@Data
public class OfferListResponse {
    private List<Item> offersList;
}
