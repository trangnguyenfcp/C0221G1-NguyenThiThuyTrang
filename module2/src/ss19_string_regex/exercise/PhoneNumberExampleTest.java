package ss19_string_regex.exercise;

public class PhoneNumberExampleTest {
    private static PhoneNumberExample phoneNumberExample;
    private static String[] validPhoneNumber = new String[]{"(84)-(0978489648)"};
    private static String[] invalidPhoneNumber = new String[]{"(a8)-(22222222)"};

    public static void main(String[] args) {
        phoneNumberExample = new PhoneNumberExample();
        for (String phoneNumber : validPhoneNumber){
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }
        for (String phoneNumber : invalidPhoneNumber){
            boolean isValid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number " + phoneNumber + " is valid: " + isValid);
        }
    }
}
