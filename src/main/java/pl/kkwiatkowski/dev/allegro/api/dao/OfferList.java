package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.*;

@Data
public class OfferList {
    Items items;
    Categories categories;
    Filters filters;
    SearchMeta searchMeta;
    Sort sort;
}
