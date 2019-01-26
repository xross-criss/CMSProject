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
public class Filters {
    private String id;
    private String type;
    private String name;
    private List<FilterValue> values;
    private Number minValue;
    private Number maxValue;
    private String unit;
}
