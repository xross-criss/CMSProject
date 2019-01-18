package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Stock {
    private String unit;
    private Integer available;
}
