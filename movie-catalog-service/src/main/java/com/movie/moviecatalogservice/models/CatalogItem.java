package com.movie.moviecatalogservice.models;

public class CatalogItem {

    private String name;
    private String desc;
    private Integer rating;

    public CatalogItem() {

    }

    public CatalogItem(String name, String desc, Integer rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
