package ss19_string_regex.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static final String CLASS_REGEX = "^[C|A|P][\\d]{4}[G|H|I|K|L|M]$";
    public ClassExample(){};
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();

    }
}
