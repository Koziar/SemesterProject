/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import entity.Url;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import javax.lang.model.util.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Cookie
 */
class ping implements Callable<String> {

    String url;

    public ping(String url) {
        this.url = url;
    }


    @Override
    public String call() throws Exception {

        Document doc = Jsoup.connect("http://angularairline-plaul.rhcloud.com/").get();
//        Elements group = doc.select("#group");
//        System.out.println(group);
        return url;
    }

}

public class Pinger {

    public static void main(String[] args) throws Exception {
        List<String> urls = new ArrayList<String>() {
            {
               
                add("http://angularairline-plaul.rhcloud.com/");
               
            }
        };
        List<Future<String>> futures = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (String url : urls) {
            Callable<String> callable = new ping(url);
            Future<String> future = executor.submit(callable);
            futures.add(future);
        }
        executor.shutdown();
        for (Future<String> f : futures) {
            String result = f.get();
            System.out.println(result);
        }
    }

//    File input = new File("");
}
