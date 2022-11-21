package com.chilikinow.lesson5.pages.components;

public enum Hobby {

    Sports ("Спорт"),
    Reading ("Чтение"),
    Music ("Музыка");

    private String title;

    Hobby(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

}
