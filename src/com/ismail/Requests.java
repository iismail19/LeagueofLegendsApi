package com.ismail;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// download dependency here:  http://chillyfacts.com/download-java-json-jar/

public class Requests extends LolRequests{
    // TODO learn what each Request code stand for... and how to respond according to requestCode

    public JSONObject getRequest(String requestURL) throws IOException, JSONException {
        URL link = new URL(requestURL);
        HttpURLConnection connect = (HttpURLConnection) link.openConnection();
        // response code: tells us if the request url is successful
        int responeCode = connect.getResponseCode();
        // returns the response from the link
        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = in.readLine()) != null){
            //line = line.replace("[", "").replace("]", "");
            response.append(line);
        } in.close();

        connect.disconnect();
        JSONObject responseData = new JSONObject(response.toString());
        return  responseData;
    }

    // makes a JSON object and a list inside of it (do not use experimental)
    public JSONObject getRequestList(String requestURL) throws IOException, JSONException {
        URL link = new URL(requestURL);
        HttpURLConnection connect = (HttpURLConnection) link.openConnection();
        // response code: tells us if the request url is successful
        int responeCode = connect.getResponseCode();
        // returns the response from the link
        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        response.append("{");
        response.append("\"list\":");
        while ((line = in.readLine()) != null){
            //line = line.replace("[", "{").replace("]", "}");
            response.append(line);
        } in.close();
        response.append("}");
        connect.disconnect();
        JSONObject responseData = new JSONObject(response.toString());
        return  responseData;
    }

    // Right way to get a JSON List/Array
    public JSONArray getRequestArray(String requestURL) throws IOException, JSONException{
        URL link = new URL(requestURL);
        HttpURLConnection connect = (HttpURLConnection) link.openConnection();
        // response code: tells us if the request url is successful
        int responeCode = connect.getResponseCode();
        // returns the response from the link
        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = in.readLine()) != null){
            response.append(line);
        } in.close();
        connect.disconnect();

        JSONArray responseData = new JSONArray(response.toString());
        return  responseData;
    }


}
