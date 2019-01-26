package pl.kkwiatkowski.dev.allegro.api.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponseItem {
    private String offerId;
    private String offerName;
    private String offerPrice;
    private String offerURL;
    private String imageURL;
}
