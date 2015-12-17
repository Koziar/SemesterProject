package engine;

import entity.Url;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class SkyScanner implements Callable<String> {

    private Url airline;
    private FlightInfo flightInfo;

    public SkyScanner(Url airline, FlightInfo flightInfo) {
        this.airline = airline;
        this.flightInfo = flightInfo;
    }
    @Override
    public String call() throws IOException {
        URL url = null;
        if (flightInfo.getDestination() != null) {
            url = new URL(airline.getUrl() + "api" + '/' + "flightinfo" + '/' + flightInfo.getOrigin() + '/' + flightInfo.getDestination() + '/' + flightInfo.getFlightDate() + '/' + flightInfo.getNumOfTickets());
        } else {
            url = new URL(airline.getUrl() + "api" + '/' + "flightinfo" + '/' + flightInfo.getOrigin() + '/' + flightInfo.getFlightDate() + '/' + flightInfo.getNumOfTickets());
        }
        String flights = getInfoFromGivenURL(url);
        return flights;
    }
    private String getInfoFromGivenURL(URL url) throws IOException {
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        int HttpResult = con.getResponseCode();
        InputStreamReader is = HttpResult < 400 ? new InputStreamReader(con.getInputStream(), "utf-8")
                : new InputStreamReader(con.getErrorStream(), "utf-8");
        Scanner responseReader = new Scanner(is);
        String response = "";
        while (responseReader.hasNext()) {
            response += responseReader.nextLine() + System.getProperty("line.separator");
        }
        responseReader.close();
        return response;
    }
}
