package Directory.commons;

import FuramaResort.exception.*;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static Pattern pattern;
    public static Matcher matcher;
    public static final String PHONE_NUMBER_REGEX = "[\\d]{3}\040[\\d]{3}\040[\\d]{4}";

    public static boolean isValidRegex(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean isValid = matcher.matches();
        return isValid;

    }
    public static void isValidPhoneNumber(String phoneNumer) throws PhoneNumberException {

        if (!(FuramaResort.commons.Validators.isValidRegex(phoneNumer, Validators.PHONE_NUMBER_REGEX))){
            throw new PhoneNumberException();
        }}
    public static void isValidEmail(String email) throws EmailException {
        int countA = 0;
        int countPoint = 0;
        for (int i = 0; i < email.length(); i++){
            if (email.charAt(i) == '@'){
                countA++;
            }
            if (email.charAt(i) == '.'){
                countPoint++;
            }
        }
        if (!(countA == 1) || (countPoint == 0)){
            throw new EmailException();
        }
    }

}
