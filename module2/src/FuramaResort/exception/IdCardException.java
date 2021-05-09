package FuramaResort.exception;

public class IdCardException extends Exception {
    public IdCardException(){
        super("Id card number must be 8 digits and format: XXX XXX XXX");
    }
}
