
package engine;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wookash
 */
public class DataProcessor
{

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public List<Flight> getListOfFlights(String fs)
    {
        List<Flight> flights = new ArrayList();
        JsonObject jsonFlights = new JsonParser().parse(fs).getAsJsonObject();
        if (jsonFlights == null) {
            System.out.println("Failed! jsonFlights is null. Something went wrong");
        }

        String airline = jsonFlights.get("airline").getAsString();

        JsonArray arrayFlights = jsonFlights.get("flights").getAsJsonArray();
        for (JsonElement arrayFlight : arrayFlights) {

            String flightID = arrayFlight.getAsJsonObject().get("flightID").getAsString();
            String numberOfSeats = arrayFlight.getAsJsonObject().get("numberOfSeats").getAsString();
            String date = arrayFlight.getAsJsonObject().get("date").getAsString();
            String totalPrice = arrayFlight.getAsJsonObject().get("totalPrice").getAsString();
            String traveltime = arrayFlight.getAsJsonObject().get("traveltime").getAsString();
            String origin = arrayFlight.getAsJsonObject().get("origin").getAsString();
            String destination = arrayFlight.getAsJsonObject().get("destination").getAsString();

            int ns = Integer.parseInt(numberOfSeats);
            double tp = Double.parseDouble(totalPrice);
            int tt = Integer.parseInt(traveltime);

            Flight f = new Flight(airline, date, ns, tp, flightID, tt, destination, origin);
            flights.add(f);
        }
        return flights;
    }

}
