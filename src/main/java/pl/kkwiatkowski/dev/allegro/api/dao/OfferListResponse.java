package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OfferListResponse {
    private List<Item> offersList;
}
