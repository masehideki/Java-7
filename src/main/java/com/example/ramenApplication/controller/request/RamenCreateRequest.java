package com.example.ramenApplication.controller.request;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class RamenCreateRequest {

    @NotEmpty
    private String ramen;
    private String ramenRestaurant;
    private String genre;
    private String place;

    @Range(min = 1, max = 3)
    private int star;

    public RamenCreateRequest(String ramen, String ramenRestaurant, String genre, String place, int star) {
        this.ramen = ramen;
        this.ramenRestaurant = ramenRestaurant;
        this.genre = genre;
        this.place = place;
        this.star = star;
    }

    public String getRamen() {
        return ramen;
    }

    public String getRamenRestaurant() {
        return ramenRestaurant;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlace() {
        return place;
    }

    public int getStar() {
        return star;
    }

}
