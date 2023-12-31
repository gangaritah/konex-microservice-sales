package com.konex.drogueria.application;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Http {
  public Integer getPrice(Integer id){
    try {
      URL url = new URL("http://127.0.0.1:8083/medicines/price/"+id);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = reader.readLine()) != null) {
        response.append(inputLine);
      }
      reader.close();
      connection.disconnect();
      return Integer.parseInt(response.toString());
    } catch (IOException e) {
      e.printStackTrace();
      return -1;
    }
  }

  public String getName(Integer id){
    try {
      URL url = new URL("http://127.0.0.1:8083/medicines/name/"+id);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();
      while ((inputLine = reader.readLine()) != null) {
        response.append(inputLine);
      }
      reader.close();
      connection.disconnect();
      return response.toString();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

}
