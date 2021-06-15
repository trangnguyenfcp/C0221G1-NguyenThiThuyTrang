package model.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Validate {
    public static final String NAME = "^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$";
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
                 now = java.time.LocalDate.now();
                if (Period.between(birthDate,now).getYears()<=18) {
                    msg = "Birthday is invalid";
                }
            }catch (ParseException e){
                msg = "Birthday is invalid";
            }
    }
        return msg;}
}
