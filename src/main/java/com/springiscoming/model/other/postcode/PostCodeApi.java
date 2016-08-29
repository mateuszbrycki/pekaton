package com.springiscoming.model.other.postcode;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Mateusz on 05.06.2016.
 */
public class PostCodeApi {

    @JsonProperty("kod") private String kod;
    @JsonProperty("miejscowosc") private String miejscowosc;
    @JsonProperty("adres") private String adres;
    @JsonProperty("gmina") private String gmina;
    @JsonProperty("powiat") private String powiat;
    @JsonProperty("wojewodztwo") private String wojewodztwo;

    public PostCodeApi() {}

    public PostCodeApi(String kod, String miejscowosc, String adres, String gmina, String powiat, String wojewodztwo) {
        this.kod = kod;
        this.miejscowosc = miejscowosc;
        this.adres = adres;
        this.gmina = gmina;
        this.powiat = powiat;
        this.wojewodztwo = wojewodztwo;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getGmina() {
        return gmina;
    }

    public void setGmina(String gmina) {
        this.gmina = gmina;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }
}
