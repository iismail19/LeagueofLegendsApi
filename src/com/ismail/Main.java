package com.ismail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    // Send Get Request
    public static void test(String[] args) throws Exception{
        URL url = new URL("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key=RGAPI-86d89a5d-3b70-457b-adc6-610afab42ba7");
        HttpURLConnection newConnection = (HttpURLConnection) url.openConnection();

        // Send get request
        newConnection.setRequestMethod("GET");
        // response
        int status = newConnection.getResponseCode();
        System.out.println("Status code: " + status); // need to check status code before reading data


        // Jason to String
        BufferedReader in = new BufferedReader(
                new InputStreamReader(newConnection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        newConnection.disconnect();
    }

    public static void main(String[] args) throws IOException, JSONException{
        Requests httpRequest = new Requests();
        JSONObject resutls;
        JSONObject resultList;
        JSONArray array;
        // Single Object
        resutls = httpRequest.getRequest(httpRequest.requestSummonerByName("DeathDragon97"));
        System.out.println(resutls.toString());
        // accountId != summonerID
        // summonerId == Id

        resultList = httpRequest.getRequestList(httpRequest.requestChampionMastery(40396988));
        System.out.println(resultList.toString());
        System.out.println();
        array = httpRequest.getRequestArray(httpRequest.requestChampionMastery(40396988));
        System.out.println(array.toString());



        // List Object
    }


}
