package errorHandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException>{
    @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(InvalidInputException e) {

        ErrorMessage err = new ErrorMessage(e, 4, 400);
        return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
