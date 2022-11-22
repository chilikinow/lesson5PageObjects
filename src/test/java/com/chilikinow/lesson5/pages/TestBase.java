package com.chilikinow.lesson5.pages;

import com.chilikinow.lesson5.Student;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestBase {

    public static Student student = new Student();
    public RegistrationPage registrationPage = new RegistrationPage();
    public Faker faker = new Faker(new Locale("en-US"));
    public static final SimpleDateFormat sdfBirthdayFaker = new SimpleDateFormat("dd.MM.yyyy");

    @BeforeAll
    static void init(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }
}
