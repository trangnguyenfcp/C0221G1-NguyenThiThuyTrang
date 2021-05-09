package FuramaResort.exception;

public class BirthdayException extends Exception {
    public BirthdayException(){
        super("Birthday > 1900 and format: dd/mm/yyyy");
    }
}
