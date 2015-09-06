package runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This is the class that is used to make the api call.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class WeatherAPICall implements Runnable {

    @Override
    public void run() {
        System.out.println(sendRequest());
    }

    private String sendRequest() {
        StringBuilder builder = null;
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Dallas,US");

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            if(connection.getResponseCode() != 200) {
                throw new IOException(connection.getResponseMessage());
            }

            reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            builder = new StringBuilder();
            String response;
            while((response = reader.readLine()) != null) {
                builder.append(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return builder != null ? builder.toString() : null;
    }
}
