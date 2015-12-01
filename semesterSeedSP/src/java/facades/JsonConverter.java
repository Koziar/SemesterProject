/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Url;
import java.util.List;

/**
 *
 * @author Cookie
 */
public class JsonConverter {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    UrlFacade uf = new UrlFacade();

    public static String getJSONFromuRL(Url u) {
        return gson.toJson(u.getUrl());
    }

    public String getJSONFromuRL1(List<Url> urls) {
        JsonArray ja = new JsonArray();
        for (int i = 0; i < urls.size(); i++) {
            JsonObject jsObj = new JsonObject();
            jsObj.addProperty("url", urls.get(i).getUrl());
            ja.add(jsObj);
        }
        return gson.toJson(ja);
    }

    public static String getJSONFromUrl(List<Url> urls) {
        return gson.toJson(urls);
    }

    public static void main(String[] args) {
//        getJSONFromuRL(uf.getUrls());
    }
}
