package engine;

import DTOs.FlightReservationRequest;
import DTOs.FlightReservationResponse;
import deploy.DeploymentConfiguration;
import entity.Url;
import errorHandling.FlightException;
import errorHandling.FlightReservationException;
import errorHandling.InternalServerException;
import facades.FlightFacadeInterface;
import facades.UrlFacade;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import static javax.ws.rs.client.Entity.json;

public class MetaEngine implements FlightFacadeInterface {
    //this class handles the search for all airline flights

    private List<Url> airlines;
    private List<Flight> flights;
    private DataProcessor dataProcessor;

    public MetaEngine(List<Url> airlines) {

        this.airlines = airlines;
        this.flights = new ArrayList();
        this.dataProcessor = new DataProcessor();
    }

    //start the SkyScanner to scan for flights in each airline
    private void startSkyScanner(FlightInfo flightInfo) throws InternalServerException, FlightException {
        List<Future<String>> futures = new ArrayList();

        //create a thread pool which creates a number of threads equal to the number of airlines
        ExecutorService executor = Executors.newFixedThreadPool(airlines.size());

        for (Url airline : airlines) {
            //new scanner for each airline
            SkyScanner scanner = new SkyScanner(airline, flightInfo);

            //start a new Callable for each of the airlines
            Future<String> future = executor.submit(scanner);
            //add the future from the scanner to the futures list
            futures.add(future);
        }
        executor.shutdown();

        for (Future<String> future : futures) {
            try {
                //get the flight from the future
                String info = future.get();

                //pass the flights from each airline to the DataProcessor which will return them as a Java objects
                List<Flight> flightsFromAirline = dataProcessor.getListOfFlights(info);
                //add the flight to the flights list
                for (Flight flight : flightsFromAirline) {
                    flights.add(flight);
                }
            } catch (InterruptedException ex) {
//                throw a custom exception from the Server
                throw new InternalServerException("We are sorry for the inconvinience!Please try again :) ");
            } catch (ExecutionException ex) {
                //throw a custom exception from the Server
                throw new InternalServerException(ex.getMessage());
            }
        }
    }

    @Override
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo) throws InternalServerException, FlightException {
        //start the scanner
        startSkyScanner(flightInfo);
        //return the flights
        return flights;
    }

    @Override
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo) throws InternalServerException, FlightException {
        //start the scanner
        startSkyScanner(flightInfo);
        //return the flights
        return flights;
    }

    @Override
    public FlightReservationResponse bookFlight(FlightReservationRequest flightReservationRequest) throws InternalServerException, FlightReservationException {

        //problem: cannot find airline here, so we will book always with our airline .... 
//        String url = "";
//        for (Url airline : airlines) {
//            if (airline.getGroupName().equals(flightReservationRequest.getAirline())) {
//                url = airline.getUrl();
//            }
//        }
        String url = "http://sargardon-001-site1.atempurl.com/api/flightreservation";
        String flightReservationRequestJSON = dataProcessor.getFlightReservationRequestJSON(flightReservationRequest);

        //find the flight with the given flightId
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty("Content-Type", "application/json;");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Method", "POST");
            con.setDoOutput(true);

            PrintWriter pw = new PrintWriter(con.getOutputStream());
            try (OutputStream os = con.getOutputStream()) {
                os.write(flightReservationRequestJSON.getBytes("UTF-8"));
            }
            int HttpResult = con.getResponseCode();
            InputStreamReader is = HttpResult < 400 ? new InputStreamReader(con.getInputStream(), "utf-8")
                    : new InputStreamReader(con.getErrorStream(), "utf-8");
            Scanner responseReader = new Scanner(is);
            String response = "";
            while (responseReader.hasNext()) {
                response += responseReader.nextLine() + System.getProperty("line.separator");
            }
            return dataProcessor.getFlightReservationResponse(response);
        } catch (IOException ex) {
            throw new InternalServerException("We are sorry for the inconvinience!Please try again :) ");
        }

    }
}
