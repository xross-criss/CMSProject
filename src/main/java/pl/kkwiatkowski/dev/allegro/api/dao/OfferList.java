package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.*;

import java.util.List;

@Data
public class OfferList {
    Items items;
    Categories categories;
    List<Filters> filters;
    SearchMeta searchMeta;
    List<Sort> sort;
}
