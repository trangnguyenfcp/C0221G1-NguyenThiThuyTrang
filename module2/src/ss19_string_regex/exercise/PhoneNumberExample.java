package ss19_string_regex.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    private final String PHONE_NUMBER_REGEX= "^\\([\\d]{2}\\)-\\(0[\\d]{9}\\)$";
    PhoneNumberExample(){}
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
