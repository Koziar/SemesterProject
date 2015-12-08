//
//package engine;
//
//import entity.Url;
//import facades.UrlFacade;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import static org.apache.catalina.tribes.util.Arrays.add;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
///**
// *
// * @author Cookie
// */
//class ping implements Callable<String> {
//
//    String url;
//
//    public ping(String url) {
//        this.url = url;
//    }
//
//    @Override
//    public String call() throws Exception {
//
//        Document doc = Jsoup.connect("http://angularairline-plaul.rhcloud.com/").get();
////        if(doc.text().contains("src")){
////				System.out.println("Airline");
////			}
//////        Elements links = doc.select("a[href]");
//////        System.out.println(links);
//////        Elements group = doc.select("#group");
//////        System.out.println(group);
//        return url;
//    }
////    public static void main(String[] args) {
//        
////        try {
////            Pinger p = new Pinger();
////            //Pinger p = new Pinger();
//////            Document doc = Jsoup.connect("http://angularairline-plaul.rhcloud.com/").get();
//////            Elements links = doc.select("a[href]"); 
//////                    Elements imports = doc.select("link[href]");
////        
////
//////            System.out.println("doc: "+doc);
////        } catch (IOException ex) {
////            Logger.getLogger(ping.class.getName()).log(Level.SEVERE, null, ex);
////        }
////}
//
//    }
//public class Pinger {
//
////    UrlFacade uf = new UrlFacade();
//    Url u = new Url();
//
//    public String getUrlsThreadPingerThingy() {
////        Pinger p = new Pinger();
//        List<String> urls = new ArrayList<String>() {
//            UrlFacade uf = new UrlFacade();
//
//            {
//
//                add(uf.getUrls().toString());
//            }
//        };
//        List<Future<String>> futures = new ArrayList();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        
//        for (String url : urls) {
//            Callable<String> callable = new ping(url);
//            Future<String> future = executor.submit(callable);
//            futures.add(future);
//        }
//        executor.shutdown();
//        for (Future<String> f : futures) {
//            try {
//                String result = f.get();
//                System.out.println("Result: " + result);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Pinger.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ExecutionException ex) {
//                Logger.getLogger(Pinger.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return urls.toString();
//       
//    }
//
//    public static void main(String[] args) {
//        Pinger p = new Pinger();
//        UrlFacade facade = new UrlFacade();
//        facade.addUrlToDB(new Url("test", "test", "http://angularairline-plaul.rhcloud.com/"));
////        p.getUrlsThreadPingerThingy();
//        
//        System.out.println(p.getUrlsThreadPingerThingy());
//    }
//
//    
//
//}