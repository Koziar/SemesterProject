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
public class FlightExceptionMapper implements ExceptionMapper<FlightException>{
    @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(FlightException e) {

        ErrorMessage err = new ErrorMessage(e, e.getErrorCode(), 404);
        return Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
