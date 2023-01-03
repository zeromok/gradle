package com.example.hello.validator;

import com.example.hello.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

//        return false;

        // yyyyMMdd
        try{

            // LocalDate 는 기본적으로 yyyyMMdd 이여서 뒤에 01 붙여줌
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));

        }catch (Exception e) {
            return false;
        }

        return true;
    }
}
