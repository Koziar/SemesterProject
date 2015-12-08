
package metaEngine;

import entity.Airline;
import facades.FlightFacadeInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetaEngine implements FlightFacadeInterface
{
    //this class searches all airlines for flights

    private List<Airline> airlines;
    private List<Flight> flights;

    public MetaEngine(List<Airline> airlines)
    {

        this.airlines = airlines;
        this.flights = new ArrayList();
    }

    //start the SkyScanner to scan for flights in each airline
    private void startSkyScanner(FlightInfo flightInfo)
    {

        List<Future<List<Flight>>> futures = new ArrayList();

        //create a thread pool which creates a number of threads equal to the number of airlines
        ExecutorService executor = Executors.newFixedThreadPool(airlines.size());

        for (Airline airline : airlines) {

            //new scanner for the airline
            SkyScanner scanner = new SkyScanner(airline, flightInfo);

            //start a new Callable for each of the airlines
            Future<List<Flight>> future = executor.submit(scanner);
            //add the future from the scanner to the futures list
            futures.add(future);
        }
        executor.shutdown();

        for (Future<List<Flight>> future : futures) {

            try {
                //get the flight from the future
                List<Flight> flightsFromFeature = future.get();
                for (Flight flightFromFeature : flightsFromFeature) {
                    flights.add(flightFromFeature);
                }
                //add the flight to the flights list

            } catch (InterruptedException ex) {
                Logger.getLogger(MetaEngine.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(MetaEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo)
    {

        //start the scanner
        startSkyScanner(flightInfo);

        //return the flights
        return flights;
    }

    @Override
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo)
    {

        //start the scanner
        startSkyScanner(flightInfo);

        //return the flights
        return flights;
    }

}
