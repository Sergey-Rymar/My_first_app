package com.example.myapplication.domain;

import org.json.JSONException;
import org.json.JSONObject;

public class Film {
    private Long id;
    private Long kinopoiskId;
    private String nameRu;
    private String nameOriginal;
    private String posterUrl;
    private String posterUrlPreview;
    private String coverUrl;
    private String logoUrl;
    private String ratingKinopoisk;
    private String ratingImdb;
    private String webUrl;
    private String description;
    private String shortDescription;

    public Film() {}

    public Film(Long id, Long kinopoiskId, String nameRu, String nameOriginal, String posterUrl, String posterUrlPreview, String coverUrl, String logoUrl, String ratingKinopoisk, String ratingImdb, String webUrl, String description, String shortDescription) {
        this.id = id;
        this.kinopoiskId = kinopoiskId;
        this.nameRu = nameRu;
        this.nameOriginal = nameOriginal;
        this.posterUrl = posterUrl;
        this.posterUrlPreview = posterUrlPreview;
        this.coverUrl = coverUrl;
        this.logoUrl = logoUrl;
        this.ratingKinopoisk = ratingKinopoisk;
        this.ratingImdb = ratingImdb;
        this.webUrl = webUrl;
        this.description = description;
        this.shortDescription = shortDescription;
    }
    public Film(JSONObject jsonObject) throws JSONException {
        this.kinopoiskId = jsonObject.getLong("kinopoiskId");
        this.nameRu = jsonObject.getString("nameRu");
        this.nameOriginal = jsonObject.getString("nameOriginal");
        this.posterUrl = jsonObject.getString("posterUrl");
        this.posterUrlPreview = jsonObject.getString("posterUrlPreview");
//        this.coverUrl = jsonObject.getString("coverUrl");
//        this.logoUrl = jsonObject.getString("logoUrl");
        this.ratingKinopoisk = jsonObject.getString("ratingKinopoisk");
        this.ratingImdb = jsonObject.getString("ratingImdb");
//        this.webUrl = jsonObject.getString("webUrl");
//        this.description = jsonObject.getString("description");
//        this.shortDescription = jsonObject.getString("shortDescription");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKinopoiskId() {
        return kinopoiskId;
    }

    public void setKinopoiskId(Long kinopoiskId) {
        this.kinopoiskId = kinopoiskId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public void setPosterUrlPreview(String posterUrlPreview) {
        this.posterUrlPreview = posterUrlPreview;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public void setRatingKinopoisk(String ratingKinopoisk) {
        this.ratingKinopoisk = ratingKinopoisk;
    }

    public String getRatingImdb() {
        return ratingImdb;
    }

    public void setRatingImdb(String ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
