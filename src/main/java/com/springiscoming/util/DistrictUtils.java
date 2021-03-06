package com.springiscoming.util;

import static java.util.Arrays.asList;

/**
 * Created by Mateusz on 05.06.2016.
 */
public class DistrictUtils {
    public static Boolean isDistrict(String district) {
        return asList(
                "małopolskie", "podkarpackie", "śląskie", "pomorskie",
                "warmińsko-mazurskie", "podlaskie", "zachodnio-pomorskie",
                "kujawsko-pomorskie", "mazowieckie", "wielkopolskie",
                "lubuskie", "łódzkie", "dolnośląskie", "lubelskie",
                "opolskie", "świętokrzyskie")
                .contains(district.toLowerCase());
    }
}
