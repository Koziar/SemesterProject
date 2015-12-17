package engine;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import DTOs.PassengerContainer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import errorHandling.FlightException;
import errorHandling.FlightReservationException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public List<Flight> getListOfFlights(String fs) throws FlightException {
        List<Flight> flights = new ArrayList();
        JsonObject jsonFlights = new JsonParser().parse(fs).getAsJsonObject();

        //check if the jsonFLights object contains httpError attribute
        if (jsonFlights.get("httpError") != null) {
            return flights;
        }
        String airline = "";

        if (jsonFlights.get("airline") != null) {
            airline = jsonFlights.get("airline").getAsString();
        }
        if (jsonFlights.get("flights") != null) {

            JsonArray arrayFlights = jsonFlights.get("flights").getAsJsonArray();
            for (JsonElement arrayFlight : arrayFlights) {

                String flightID = "";
                int numberOfSeats = 0;
                String date = "";
                double totalPrice = 0.0;
                int traveltime = 0;
                String origin = "";
                String destination = "";

                if (arrayFlight.getAsJsonObject().get("flightID") != null) {
                    flightID = arrayFlight.getAsJsonObject().get("flightID").getAsString();

                }
                if (arrayFlight.getAsJsonObject().get("numberOfSeats") != null) {
                    numberOfSeats = arrayFlight.getAsJsonObject().get("numberOfSeats").getAsInt();

                }
                if (arrayFlight.getAsJsonObject().get("date") != null) {
                    date = arrayFlight.getAsJsonObject().get("date").getAsString();

                }
                if (arrayFlight.getAsJsonObject().get("totalPrice") != null) {
                    totalPrice = arrayFlight.getAsJsonObject().get("totalPrice").getAsDouble();

                }
                if (arrayFlight.getAsJsonObject().get("traveltime") != null) {
                    traveltime = arrayFlight.getAsJsonObject().get("traveltime").getAsInt();

                }
                if (arrayFlight.getAsJsonObject().get("origin") != null) {
                    origin = arrayFlight.getAsJsonObject().get("origin").getAsString();

                }
                if (arrayFlight.getAsJsonObject().get("destination") != null) {
                    destination = arrayFlight.getAsJsonObject().get("destination").getAsString();

                }
                Flight f = new Flight(airline, date, numberOfSeats, totalPrice, flightID, traveltime, destination, origin);
                flights.add(f);
            }
        }
        //otherwise get all the flight data
        return flights;
    }

    public String getFlightReservationRequestJSON(FlightReservationRequest flightReservationRequest) {
        return gson.toJson(flightReservationRequest);
    }

    FlightReservationResponse getFlightReservationResponse(String response) throws FlightReservationException {

        JsonObject jsonReservationResponse = new JsonParser().parse(response).getAsJsonObject();
        //check if the jsonFLights object contains httpError attribute
        if (jsonReservationResponse.get("httpError") != null) {
            //so we have an error response
            //throw FlightReservationException 
            int errorCode = jsonReservationResponse.get("errorCode").getAsInt();
            String message = jsonReservationResponse.get("message").getAsString();
            throw new FlightReservationException("Some errors cannot be fixed!!!!", errorCode);
        }
        //otherwise get all the flight data
        List<PassengerContainer> passengers = new ArrayList();

        String flightID = jsonReservationResponse.get("flightID").getAsString();
        String origin = jsonReservationResponse.get("Origin").getAsString();
        String destination = jsonReservationResponse.get("Destination").getAsString();
        String date = jsonReservationResponse.get("Date").getAsString();
        int travelTime = jsonReservationResponse.get("FlightTime").getAsInt();
        int numberOfSeats = jsonReservationResponse.get("numberOfSeats").getAsInt();
        String ReserveeName = jsonReservationResponse.get("ReserveeName").getAsString();

        JsonArray jPassengers = jsonReservationResponse.get("Passengers").getAsJsonArray();
        for (JsonElement passenger : jPassengers) {

            String firstName = passenger.getAsJsonObject().get("firstName").getAsString();
            String lastName = passenger.getAsJsonObject().get("lastName").getAsString();
            passengers.add(new PassengerContainer(firstName, lastName));
        }
        FlightReservationResponse flightReservationResponse = new FlightReservationResponse(flightID, origin, destination, date, travelTime, numberOfSeats, ReserveeName, passengers);

        return flightReservationResponse;

    }
}
