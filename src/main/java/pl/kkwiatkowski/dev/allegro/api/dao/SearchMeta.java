package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchMeta {
    private Integer availableCount;
    private Integer totalCount;
    private boolean fallback;
}
