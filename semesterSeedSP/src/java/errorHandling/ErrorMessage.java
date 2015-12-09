package errorHandling;

/**
 *
 * @author terziev
 */
public class ErrorMessage {
    
    private int errorCode;
    private String message;
    private int httpError;

    public ErrorMessage(Throwable ex, int errorCode, int httpError) {
        
        this.httpError = httpError;
        this.errorCode = errorCode;
        this.message = ex.getMessage();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpError() {
        return httpError;
    }
    
    
    
    
}
