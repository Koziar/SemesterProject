
package engine;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author wookash
 */
public class MetaEngine
{

    public static String getFlightsFrom(String from, String date, Integer persons) throws MalformedURLException, IOException
    {
        URL url = new URL("http://angularairline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + date + "/" + persons);
        return getInfoFromGivenURL(url);
    }

    public static String getFlightsFromTO(String from, String to, String date, Integer persons) throws MalformedURLException, IOException
    {
        URL url = new URL("http://angularairline-plaul.rhcloud.com/api/flightinfo/" + from + "/" + to + "/" + date + "/" + persons);
        return getInfoFromGivenURL(url);
    }

    private static String getInfoFromGivenURL(URL url) throws IOException
    {

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json; charset=UTF-8");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = "";
        while (scan.hasNext()) {
            jsonStr += scan.nextLine();
        }
        scan.close();

        return jsonStr;
    }


}
