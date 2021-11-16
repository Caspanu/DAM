package com.example.whatsapptema;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    public void read(String urlpath, IResponse response){
        try {
            URL url = new URL(urlpath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(inputReader);

            StringBuilder result = new StringBuilder();
            String line = "";
            while((line = reader.readLine()) != null){
                result.append(line);
            }
            Log.v("rezultat", result.toString());

            reader.close();
            inputReader.close();
            input.close();

            List<Conversatie> list = parsare(result.toString());
            response.onSuccess(list);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }

    }

    private List<Conversatie> parsare(String jsonString) {
        List<Conversatie> lst = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray array = jsonObject.getJSONArray("conversatie");
            for (int i =0; i<array.length(); i++){
                JSONObject currentObject = array.getJSONObject(i);

                String nume = currentObject.getString("nume");
                String mesaj = currentObject.getString("mesaj");
                String data = currentObject.getString("data");

                Conversatie c1 = new Conversatie(nume, mesaj, data);
                lst.add(c1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lst;
    }
}
