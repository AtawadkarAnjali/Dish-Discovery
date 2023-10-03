package com.myapps.appdd.models;

public class RecommendedModel {
    String name;
    String image_url;
    String description;
    String rating;
    String time;

    public RecommendedModel(){

    }

    public RecommendedModel(String name,String image_url,String description,String rating,String time){
        this.name = name;
        this.image_url = image_url;
        this.description = description;
        this.rating = rating;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
