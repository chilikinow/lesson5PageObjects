package com.chilikinow.lesson5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateOfBirth {

    private LocalDate dateOfBirth;

    public DateOfBirth(String date){
        String europeanDatePattern = "dd.MM.yyyy";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        dateOfBirth = LocalDate.parse(date, europeanDateFormatter);
    }

    public DateOfBirth(LocalDate date){
        this.dateOfBirth = date;
    }

    public LocalDate getLocalDate(){
        return this.dateOfBirth;
    }

    public String getMonthStartToUppercase(){
        String month = this.dateOfBirth.getMonth().name();
        return month.substring(0, 1) + month.substring(1).toLowerCase();
    }
}
