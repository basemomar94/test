package com.dadon.projectfikm;

public class Film {
    String idfilm = "";
    String title = "";
    String  language ="";
    Integer rate ;

    public Film(String s, String idfilm, String title, String language, Integer rate) {
        this.idfilm = idfilm;
        this.title = title;
        this.language = language;
        this.rate = rate;
    }



    public String getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(String idfilm) {
        this.idfilm = idfilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }





    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
