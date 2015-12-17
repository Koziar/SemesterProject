package errorHandling;

public class FlightReservationException extends Exception{

    private int errorCode;
    
    public FlightReservationException(String message) {
        super(message);
    }

    public FlightReservationException(String message, int errorCode) {
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
