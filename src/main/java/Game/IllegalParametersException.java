package Game;

public class IllegalParametersException extends RuntimeException {
    public IllegalParametersException(String errorMassage){
        super(errorMassage);
    }
}
