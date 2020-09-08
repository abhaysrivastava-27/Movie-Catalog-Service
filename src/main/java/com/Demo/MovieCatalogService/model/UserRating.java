package com.Demo.MovieCatalogService.model;

import java.util.List;

public class UserRating {
    private List<Rating> listOfRating;

    public List<Rating> getListOfRating() {
        return listOfRating;
    }

    public void setListOfRating(List<Rating> listOfRating) {
        this.listOfRating = listOfRating;
    }
}
