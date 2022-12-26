package com.chilikinow.lesson5.pages;

import com.chilikinow.lesson5.Student;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestBase {

    public Student student;
    public RegistrationPage registrationPage;
    public Faker faker;
    public static final SimpleDateFormat sdfBirthdayFaker;

    static {
        sdfBirthdayFaker = new SimpleDateFormat("dd.MM.yyyy");
    }

    {
        student = new Student();
        registrationPage = new RegistrationPage();
        faker = new Faker(new Locale("en-US"));
    }

    @BeforeAll
    static void init(){

//        Configuration.remote = System.getProperty("url.selenoid");
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        Configuration.baseUrl = System.getProperty("base.url");
        Configuration.browserSize = System.getProperty("browser.size");
        Configuration.holdBrowserOpen = Boolean.valueOf(System.getProperty("browser.hold.open", "false"));
        Configuration.headless = Boolean.valueOf(System.getProperty("browser.headless", "false"));

    }
}

// gradle clean main_tests -Dbase.url="https://demoqa.com" -Dbrowser.size="1920x1080" -Dselenide.browser=Chrome -Dbrowser.headless=true