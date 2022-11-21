package com.chilikinow.lesson5;

import com.chilikinow.lesson5.pages.components.Gender;
import com.chilikinow.lesson5.pages.components.Hobby;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebPageTest extends TestBase{

    @Test
    void positiveRegistrationFormTest(){

        registrationPage.openPage("/automation-practice-form")
            .setFIrstName("Mike")
            .setLastName("Turilov")
            .setEmail("example@google.com")
            .chooseGender(Gender.Male)
            .setPhoneNumber("9001546995")
            .setSubject("Maths")
            .chooseHobby(Hobby.Sports)
            .uploadPicture("jpg/photo_2022-11-18_20-47-02.jpg")
            .setAddress("Some Address");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--012").click();

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();



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