package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FilterValue {
    private String name;
    private String value;
    private String idSuffix;
    private Integer count;
    private boolean selected;
}
