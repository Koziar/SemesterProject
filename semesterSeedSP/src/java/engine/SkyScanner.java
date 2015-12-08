
package engine;

import entity.Url;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class SkyScanner implements Callable<List<Flight>>
{

    private Url airline;
    private FlightInfo flightInfo;

    public SkyScanner(Url airline, FlightInfo flightInfo)
    {
        this.airline = airline;
        this.flightInfo = flightInfo;
    }

    @Override
    public List<Flight> call() throws Exception
    {
        DataProcessor dp = new DataProcessor();
        URL url = null;
        if (flightInfo.getDestination() != null) {
            url = new URL(airline.getUrl() + '/' + "flightinfo" + '/' + flightInfo.getOrigin() + '/' + flightInfo.getDestination() + '/' + flightInfo.getFlightDate() + '/' + flightInfo.getNumOfTickets());
        } else {
            url = new URL(airline.getUrl() + '/' + "flightinfo" + '/' + flightInfo.getOrigin() + '/' + flightInfo.getFlightDate() + '/' + flightInfo.getNumOfTickets());
        }
        String flights = getInfoFromGivenURL(url);
        return dp.getListOfFlights(flights);
    }

    private String getInfoFromGivenURL(URL url) throws IOException
    {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json; charset=UTF-8");
            Scanner scan = new Scanner(con.getInputStream());
            String jsonStr = "";
            while (scan.hasNext()) {
                jsonStr += scan.nextLine();
            }
            scan.close();
            return jsonStr;

        } catch (IOException e) {

            System.out.println(con.getResponseCode() + " " + con.getResponseMessage());
        }
        return "Error occured! ^";
    }

}
