package FuramaResort.exception;

public class GenderException extends Exception{
    public GenderException(){
        super("Input must be Male or Female or Unknown");
    }
}
