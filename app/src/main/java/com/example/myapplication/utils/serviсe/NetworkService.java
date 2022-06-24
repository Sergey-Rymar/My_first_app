package com.example.myapplication.utils.serviсe;

import android.net.Uri;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class NetworkService {

    private static final String API_KEY ="134bf90a-f80e-49f5-92ae-0f103a4a97b7";
    private static final String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films";
    private static final String ORDER = "?order=";
    private static final String POP = "NUM_VOTE";
    private static final String RATE = "RATING";

    public static URL buildURL(Boolean isRate){
        Uri uri;
        if (isRate)
            uri = Uri.parse(url+ORDER+RATE);
        else
            uri = Uri.parse(url+ORDER+POP);
        URL result = null;
        try {
            result = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONObject getJSONFromNetwork(Boolean isRate){
        URL url = buildURL(isRate);
        JSONObject result = null;
        try {
            result = new JSONLoadTask().execute(url).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class JSONLoadTask extends AsyncTask<URL, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(URL... urls) {

            if (urls == null || urls.length == 0)
            return null;
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) urls[0].openConnection();
                connection.setRequestProperty("X-API-KEY", API_KEY);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                while (line != null) {
                    stringBuilder.append(line);
                    line = reader.readLine();
                }
                return new JSONObject(stringBuilder.toString());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }
    }
}

