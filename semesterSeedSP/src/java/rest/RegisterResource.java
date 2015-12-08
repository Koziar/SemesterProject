/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import facades.UserFacade;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import entity.User;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author wookash
 */
@Path("register")
public class RegisterResource
{

    private static Gson gson;
    private static UserFacade userFacade;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public RegisterResource()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
        userFacade = new UserFacade();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response registerNewUser(String userDetails)
    {
        JsonObject jo = new JsonParser().parse(userDetails).getAsJsonObject();

        String username = jo.get("username").getAsString();
        String password = jo.get("password").getAsString();
        String email = jo.get("email").getAsString();
        String firstname = jo.get("firstname").getAsString();
        String lastname = jo.get("lastname").getAsString();

        JsonObject jnewUser = new JsonObject();
        if (!username.trim().equals("") || !password.trim().equals("")) {
            User newUser = new User(username, password, email, firstname, lastname);
            User newUserReturned = userFacade.registerNew(newUser);

            jnewUser.addProperty("username", newUserReturned.getUserName());
            jnewUser.addProperty("role", newUserReturned.getRoles().get(0).getRoleName());
        }

        return Response.ok(gson.toJson(jnewUser)).build();
    }

}
