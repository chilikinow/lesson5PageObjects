package com.chilikinow.lesson5.pages.components;

public enum Gender {

    Male ("Мужчина"),
    Female ("Женщина"),
    Other ("Иное");

    private String title;

    Gender(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

}
