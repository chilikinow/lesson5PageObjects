package com.chilikinow.lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework{

    private String text;

    @BeforeAll
    static void init(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTests(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Turilov");
        $("#userEmail").setValue("example@google.com");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9001546995");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Maths");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").pressTab();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("jpg/photo_2022-11-18_20-47-02.jpg");
        $("#currentAddress").setValue("Some Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        $(".modal-content").shouldBe(Condition.visible);
//        $(".modal-content").shouldHave(text("Mike Turilov"));
//        $(".modal-content").shouldHave(text("example@google.com"));
//        $(".modal-content").shouldHave(text("Male"));
//        $(".modal-content").shouldHave(text("9001546995"));
//        $(".modal-content").shouldHave(text("12 January,1985"));
//        $(".modal-content").shouldHave(text("Maths"));
//        $(".modal-content").shouldHave(text("Sports"));
//        $(".modal-content").shouldHave(text("1.png"));
//        $(".modal-content").shouldHave(text("Some Address"));
//        $(".modal-content").shouldHave(text("NCR Delhi"));
//        $("#closeLargeModal").click();

//        $(".modal-dialog").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text("userName"), text("Egorov"),
//                text("alex@egorov.com"), text("1234567890"));

    }
}