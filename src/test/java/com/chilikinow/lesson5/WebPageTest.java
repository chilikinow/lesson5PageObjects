package com.chilikinow.lesson5;

import com.chilikinow.lesson5.pages.TestBase;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebPageTest extends TestBase {

    @BeforeEach
    void BeforeEach() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                address = faker.address().fullAddress(),
                subject = "Maths",
                state = "NCR",
                city = "Delhi";

        Gender gender = Gender.randomGender();
        Hobby hobby = Hobby.randomHobby();
        DateOfBirth dateOfBirth = new DateOfBirth(sdfBirthdayFaker.format(faker.date().birthday()));
        File picture = new File("src/main/resources/jpg/photo_2022-11-18_20-47-02.jpg");


         student = Student.builder()
                            .firstName(firstName)
                            .lastName(lastName)
                            .email(email)
                            .phoneNumber(phoneNumber)
                            .gender(gender)
                            .address(address)
                            .subject(subject)
                            .hobby(hobby)
                            .dateOfBirth(dateOfBirth)
                            .picture(picture)
                            .state(state)
                            .city(city)
                            .build();
    }

    @Test
    void positiveRegistrationFormTest(){

        registrationPage.openPage("/automation-practice-form")
            .setFirstName(student.getFirstName())
            .setLastName(student.getLastName())
            .setEmail(student.getEmail())
            .chooseGender(student.getGender())
            .setPhoneNumber(student.getPhoneNumber())
            .setSubject(student.getSubject())
            .chooseHobby(student.getHobby())
            .uploadPicture(student.getPicture())
            .setAddress(student.getAddress())
            .setState(student.getState())
            .setCity(student.getCity())
            .setDateOfBirth(student.getDateOfBirth())
            .submit();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".modal-content").shouldBe(Condition.visible);
        $(".modal-content").shouldHave(text(student.getFirstName() + " " + student.getLastName()));
        $(".modal-content").shouldHave(text(student.getEmail()));
        $(".modal-content").shouldHave(text(student.getGender().toString()));
        $(".modal-content").shouldHave(text(student.getPhoneNumber()));
        $(".modal-content").shouldHave(text(

                student.getDateOfBirth().getLocalDate().getDayOfMonth()
                + " "
                + student.getDateOfBirth().getMonthStartToUppercase()
                + ","
                + student.getDateOfBirth().getLocalDate().getYear()

        ));
        $(".modal-content").shouldHave(text(student.getSubject()));
        $(".modal-content").shouldHave(text(student.getHobby().toString()));
        $(".modal-content").shouldHave(text(student.getPicture().getName()));
        $(".modal-content").shouldHave(text(student.getAddress()));
        $(".modal-content").shouldHave(text(student.getState() + " " + student.getCity()));
        $("#closeLargeModal").click();


    }
}