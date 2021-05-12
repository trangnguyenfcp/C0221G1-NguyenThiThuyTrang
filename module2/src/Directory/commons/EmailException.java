package Directory.commons;

public class EmailException extends Exception {
    public EmailException(){
        super("Email must be in form abc@abc.abc");
    }
}
