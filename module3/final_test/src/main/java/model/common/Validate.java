package model.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Validate {
    public static final String CUSTOMER_CODE = "^(KH-)[0-9]{4}$";
    public static final String PHONE = "^(\\(84\\)\\+|0)9[0|1][\\d]{7}$";
    public static final String ID_CARD = "^([\\d]{9}|[\\d]{12})$";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NUMBER = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String SERVICE_CODE = "^[1-9][\\d]*$";
    public static final String DOUBLE = "^[0-9]+\\.?[0-9]*$";
    public static final String NAME = "^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$";
    public static String validateCustomerCode(String customerCode) {
        String msg = "";
        if ("".equals(customerCode)) {
            msg = "Please input code";
        } else if (!customerCode.matches(CUSTOMER_CODE)) {
            msg = "Customer Code is invalid";
        }
        return msg;
    }
    public static String validatePhone(String phone){
        String msg = "";
        if ("".equals(phone)) {
            msg = "Please input phone number";
        } else if (!phone.matches(PHONE)) {
            msg = "Phone number is invalid";
        }
        return msg;
    }
    public static String validateIdCard(String idCard){
        String msg = "";
        if ("".equals(idCard)) {
            msg = "Please input ID Card";
        } else if (!idCard.matches(ID_CARD)) {
            msg = "ID Card is invalid";
        }
        return msg;
    }
    public static String validateEmail(String email){
        String msg = "";
        if ("".equals(email)) {
            msg = "Please input Email";
        } else if (!email.matches(EMAIL)) {
            msg = "Email is invalid";
        }
        return msg;
    }
    public static String validateNumber(String number){
        String msg = "";
        if ("".equals(number)) {
            msg = "Please input number";
        } else if (!number.matches(NUMBER)) {
            msg = "Number is invalid";
        }
        return msg;
    }
    public static String validateName(String name) {
        String msg = "";
        if ("".equals(name)) {
            msg = "Please input name";
        } else if (!name.matches(NAME)) {
            msg = "Name is invalid";
        }
        return msg;
    }
    public static String validateBirthday(String birthday) throws ParseException {
        String msg = "";

        if ("".equals(birthday)) {
            msg = "Please input birthday";
        } else {
            Date birthday1;
            LocalDate birthDate;
            LocalDate now;
            try {
                birthday1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                Instant instant = birthday1.toInstant();
                birthDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
                now = LocalDate.now();
                if (Period.between(birthDate,now).getYears()<=18) {
                    msg = "Birthday is invalid";
                }
            }catch (ParseException e){
                msg = "Birthday is invalid";
            }
        }
        return msg;}
}
