package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Item {
    private String id;
    private String name;
    private Seller seller;
    private Promotion promotion;
    private Delivery delivery;
    private List<Images> images;
    private SellingMode sellingMode;
    private Stock stock;
    private Category category;
    private Publication publication;
}
