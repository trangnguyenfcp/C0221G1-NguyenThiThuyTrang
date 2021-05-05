package FuramaResort.commons;

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

}
