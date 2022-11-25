package com.chilikinow.lesson5.pages;

import com.chilikinow.lesson5.DateOfBirth;
import com.chilikinow.lesson5.Gender;
import com.chilikinow.lesson5.Hobby;
import com.chilikinow.lesson5.pages.components.Modal;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class RegistrationPage {

    @Getter
    private Modal modal;

    {
        modal = Modal.builder()
                    .dialog($(".modal-dialog"))
                    .dialogTitle($("#example-modal-sizes-title-lg"))
                    .content($(".modal-content"))
                    .build();
    }

    private final SelenideElement firstNameInput = $("#firstName"),
                                    lastNameInput = $("#lastName"),
                                    emailInput = $("#userEmail"),
                                    phoneNumberInput = $("#userNumber"),
                                    subjectsInput = $("#subjectsInput"),
                                    uploadPicture = $("#uploadPicture"),
                                    addressInput = $("#currentAddress"),
                                    submitButton = $("#submit");

    public RegistrationPage openPage(String url){
        open(url);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender(Gender gender){
        switch (gender){
            case Male:
                $("#gender-radio-1").doubleClick();
                break;
            case Female:
                $("#gender-radio-2").doubleClick();
                break;
            case Other:
                $("#gender-radio-3").doubleClick();
                break;
        }

        return this;
    }

    public RegistrationPage setPhoneNumber(String value){
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectsInput.click();
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        subjectsInput.pressTab();
        return this;
    }

     public RegistrationPage chooseHobby(Hobby hobby){
        switch (hobby){
            case Sports:
                $("#hobbies-checkbox-1").parent().click();
                break;
            case Reading:
                $("#hobbies-checkbox-2").parent().click();
                break;
            case Music:
                $("#hobbies-checkbox-3").parent().click();
                break;
        }

        return this;
    }

    public RegistrationPage uploadPicture(File file){
        uploadPicture.uploadFile(file);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String state){
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city){
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(DateOfBirth dateOfBirth){

        String day = dateOfBirth.getDayByTwoCharString();
        String month = dateOfBirth.getMonthStartToUppercase();
        String year = String.valueOf(dateOfBirth.getLocalDate().getYear());

        log.info("day: {}, month: {}, year: {}", day, month, year);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

}
