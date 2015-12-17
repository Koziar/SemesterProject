package errorHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author terziev
 */
@Provider
public class FlightReservationExceptionMapper implements ExceptionMapper<FlightReservationException>{
    @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(FlightReservationException e) {

        ErrorMessage err = new ErrorMessage(e, e.getErrorCode(), 400);
        return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
