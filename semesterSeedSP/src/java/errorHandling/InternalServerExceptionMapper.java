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
public class InternalServerExceptionMapper implements ExceptionMapper<InternalServerException>{
    @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(InternalServerException e) {

        ErrorMessage err = new ErrorMessage(e, 3, 500);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
