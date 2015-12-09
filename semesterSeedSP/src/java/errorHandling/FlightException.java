package errorHandling;

/**
 *
 * @author terziev
 */
public class FlightException extends Exception{

    private int errorCode;
    
    public FlightException(String message) {
        super(message);
    }

    public FlightException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
//        this.htttpError = httpError;
    }

    public int getErrorCode() {
        return errorCode;
    }

//    public int getHtttpError() {
//        return htttpError;
//    }
    
}
