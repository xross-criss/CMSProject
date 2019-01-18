package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SellingMode {
    private String format;
    private Price price;
    private Integer popularity;
}
