
package engine;

import entity.Url;
import errorHandling.FlightException;
import errorHandling.InternalServerException;
import facades.FlightFacadeInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MetaEngine implements FlightFacadeInterface
{
    //this class handles the search for all airline flights

    private List<Url> airlines;
    private List<Flight> flights;
    private DataProcessor dataProcessor;

    public MetaEngine(List<Url> airlines)
    {

        this.airlines = airlines;
        this.flights = new ArrayList();
        this.dataProcessor = new DataProcessor();
    }

    //start the SkyScanner to scan for flights in each airline
    private void startSkyScanner(FlightInfo flightInfo) throws InternalServerException, FlightException
    {
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
                //throw a custom exception from the Server
                throw new InternalServerException("We are sorry for the inconvinience!Please try again :) ");
            } catch (ExecutionException ex) {
                //throw a custom exception from the Server
                throw new InternalServerException("We are sorry for the inconvinience!Please try again :) ");
            }
        }
    }
    @Override
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo) throws InternalServerException, FlightException
    {
        //start the scanner
        startSkyScanner(flightInfo);
        //return the flights
        return flights;
    }
    @Override
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo) throws InternalServerException, FlightException
    {
        //start the scanner
        startSkyScanner(flightInfo);
        //return the flights
        return flights;
    }
}
