package com.chilikinow.lesson5.pages;

import com.chilikinow.lesson5.pages.components.Gender;
import com.chilikinow.lesson5.pages.components.Hobby;
import com.codeborne.selenide.SelenideElement;
import com.sun.tools.javac.jvm.Gen;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
    firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");



    public RegistrationPage openPage(String url){
        open(url);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFIrstName(String value){
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
            case Music:
                $("#hobbies-checkbox-2").parent().click();
                break;
            case Reading:
                $("#hobbies-checkbox-3").parent().click();
                break;
        }

        return this;
    }

    public RegistrationPage uploadPicture(String classPath){
        uploadPicture.uploadFromClasspath(classPath);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage submit(){
        submitButton.click();
        return this;
    }

}
