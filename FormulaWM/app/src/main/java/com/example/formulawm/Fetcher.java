package com.example.formulawm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Fetcher extends Thread {


    private Fetcher()
    {

    }

    public void run()
    {
        System.out.println("We made it into a New Thread----------------------------------------------------------------------------");
        try {
        URL url = new URL("https://ergast.com/api/f1/current/driverStandings.json");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        String inline = "";
        if(responsecode != 200) throw new RuntimeException("HttpResponseCode: " +responsecode);
        else{
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext())
            {
                inline +=sc.nextLine();
            }
            System.out.println("\nJSON data in string format");
            System.out.println(inline);
            sc.close();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

