package pl.kkwiatkowski.dev.allegro.api.constants;

import java.time.LocalDateTime;

public class Constants {
    public static final String AUTHORIZATION_URL = "https://allegro.pl/auth/oauth/token?grant_type=client_credentials";
    public static String ACCESS_TOKEN;
    public static LocalDateTime AUTHORIZED_LOCALDATETIME;
    public static final String CATEGORY_ID = "42540aec-367a-4e5e-b411-17c09b08e41f";
    public static final String GET_LISTING_URL = "https://api.allegro.pl/offers/listing";
    public static final String AUTHORIZATION_CREDENTIALS = "ZTg5MzdmMGUzNTUxNDFmZDgyZjdkNTBkOGVhODEzNGY6U3kyeWdCeWRaWmVqNzVTOG5uVTFoYmhpeHd3OTBqUzZuRnRjaGQ1Mmc3ZTZGVDdhOVVaajIwbm9Sa2JyTEc0Tw==";
    public static final String ALLEGRO_JSON_TYPE = "application/vnd.allegro.public.v1+json";
    public static final int PROMOTED_OFFERS_VALUE = 2;
    public static final int REGULAR_OFFERS_VALUE = 1;
    public static final String OFFERS_URL = "http://www.allegro.pl/oferta/";
}