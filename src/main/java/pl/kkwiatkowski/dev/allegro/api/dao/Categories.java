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
public class Categories {
    private List<SubCategories> subcategories;
    private Path path;
}
