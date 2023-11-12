package com.example.ramenApplication.controller.request;

import java.time.LocalDate;

public class RamenUpdateRequest {
    private String ramen;
    private String ramenRestaurant;
    private String genre;
    private String place;
    private int star;

    public RamenUpdateRequest(String ramen, String ramenRestaurant, String genre, String place, int star) {
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
