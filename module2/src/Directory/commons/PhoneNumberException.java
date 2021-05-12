package Directory.commons;

public class PhoneNumberException extends Exception {
    public PhoneNumberException(){
        super("Phone number must be 10 digits and format: XXX XXX XXXX");
    }
}
