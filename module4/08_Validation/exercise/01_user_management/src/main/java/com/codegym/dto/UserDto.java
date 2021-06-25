package com.codegym.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@Component
public class UserDto implements Validator {
    @Size(min = 5, max = 45, message = "number of characters from 5 to 45")
    private String firstName;
    @Size(min = 5, max = 45, message = "number of characters from 5 to 45")
    private String lastName;

    private String phoneNumber;

    private String email;
    @Min(value = 18, message = "age >= 18")
    private int age;

    public UserDto(){

    }
    public UserDto(String firstName, String lastName, String phoneNumber, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
            UserDto userDto = (UserDto) target;
            if (!userDto.email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")){
                errors.rejectValue("email","email.invalidFormat","Invalid format, example: trangnguyenfcp@gmail.com");
            }
    }
}
