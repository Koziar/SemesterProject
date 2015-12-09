package engine;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import errorHandling.FlightException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor
{

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public List<Flight> getListOfFlights(String fs) throws FlightException
    {
        List<Flight> flights = new ArrayList();
        JsonObject jsonFlights = new JsonParser().parse(fs).getAsJsonObject();

        //check if the jsonFLights object contains httpError attribute
        if(jsonFlights.get("httpError") != null){
            //so we have an error response
            //throw FlightException 
            int errorCode = jsonFlights.get("errorCode").getAsInt();
            String message = jsonFlights.get("message").getAsString();
            throw new FlightException(message, errorCode);
        }
        //otherwise get all the flight data
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
