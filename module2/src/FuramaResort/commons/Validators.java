package FuramaResort.commons;

import FuramaResort.exception.*;

import java.awt.desktop.OpenURIEvent;
import java.net.BindException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static Pattern pattern;
    public static Matcher matcher;
    public static final String SERVICE_ID_REGEX = "SV(VL|HO|RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";
    public static final String ID_CARD_REGEX = "[\\d]{3}\040[\\d]{3}\040[\\d]{3}";
    public static final String BIRTHDAY_REGEX = "[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}";

    public static boolean isValidRegex(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean isValid = matcher.matches();
        return isValid;

    }
    public static boolean isValidService(String str, String regex){
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean isValid = matcher.matches();
        if (!isValid){
            System.out.println("Input not matching " + regex);
        }
        return isValid;
    }
    public static boolean isMoreThan(Double number, double destNumber){
        boolean isValid = number > destNumber;
        if (!isValid){
            System.out.println("Input is not more than " + destNumber);
        }
        return isValid;
    }
    public static boolean isMoreThan(Double number, double endNumber, double destNumber){
        boolean isValid = number > destNumber && number < endNumber;
        if (!isValid){
            System.out.println("Input is not in the range: " +destNumber + " - " + endNumber);
        }
        return isValid;
    }
    public static boolean isValidFreeService(String freeService){
        String[] freeServices = {"massage", "karaoke", "food", "car"};
        boolean isValid = Arrays.asList(freeServices).contains(freeService);
        if (!isValid){
            System.out.println("Input is not in free service list");
        }
    return isValid;
    }
    public static void isValidName(String name) throws NameException {
        String[] nameElements = name.split(",");
        for (String element: nameElements){
            if(Character.isLowerCase(element.charAt(0))){
                throw new NameException();
            }
        }
        for (int i = 0; i < name.length()-1; i++){
            if (name.charAt(i) == ' ' && name.charAt(i+1) == ' '){
                throw new NameException();
            }
        }
    }
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
    public static void isValidGender(String gender) throws GenderException {
        gender = gender.toLowerCase();
       String[]  genders = {"male", "female", "unknown"};
       if (!(Arrays.asList(genders).contains(gender))){
           throw new GenderException();
       }

    }
    public static void isValidIdCard(String idCard) throws IdCardException {

        if (!(Validators.isValidRegex(idCard, Validators.ID_CARD_REGEX))){
            throw new IdCardException();
    }}
    public static void isValidBirthday(String dayOfBirth) throws BirthdayException {
        if (!(Validators.isValidRegex(dayOfBirth, Validators.BIRTHDAY_REGEX))){
            throw new BirthdayException();
        } else {
            int birthYear = Integer.parseInt(dayOfBirth.split("/")[2]);
            int currentYear = Year.now().getValue();
            if ((birthYear<=1900) || (18>(currentYear-birthYear))){
                throw new BirthdayException();
            }
        }
    }
}
