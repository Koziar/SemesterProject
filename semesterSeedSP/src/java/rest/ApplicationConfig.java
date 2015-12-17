package rest;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically populated with
   * all resources defined in the project.
   * If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
   resources.add(errorHandling.AllExceptionMapper.class);
    resources.add(errorHandling.FlightExceptionMapper.class);
    resources.add(errorHandling.FlightReservationExceptionMapper.class);
    resources.add(errorHandling.InternalServerExceptionMapper.class);
    resources.add(errorHandling.InvalidInputExceptionMapper.class);
    resources.add(rest.Admin.class);
        resources.add(rest.FlightInfoResource.class);
        resources.add(rest.FlightReservationResource.class);
        resources.add(rest.RegisterResource.class);
        resources.add(rest.User.class);
        resources.add(security.JWTAuthenticationFilter.class);
        resources.add(security.Login.class);
        resources.add(security.NotAuthorizedExceptionMapper.class);
        resources.add(security.RolesAllowedFilter.class);
  }
  
}
