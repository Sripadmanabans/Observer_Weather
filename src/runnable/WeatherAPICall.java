package runnable;

import com.google.gson.Gson;
import model.WeatherData;
import observers.CurrentConditionsDisplay;
import observers.MaximumTemperatureDisplay;
import observers.MinimumTemperatureDisplay;

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
        Gson gson = new Gson();
        String response = sendRequest();
        WeatherData weatherData = null;
        if (response != null) {
            weatherData = gson.fromJson(response, WeatherData.class);

            CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
            MaximumTemperatureDisplay maximumTemperatureDisplay = new MaximumTemperatureDisplay(weatherData);
            MinimumTemperatureDisplay minimumTemperatureDisplay = new MinimumTemperatureDisplay(weatherData);

            weatherData.measurementsChanged();
        }
    }

    /**
     * This is a function that is used to make the call to the api for getting the weather data.
     *
     * @return A string that contains the response if everything is okay and a null otherwise.
     */
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

            if (connection.getResponseCode() != 200) {
                throw new IOException(connection.getResponseMessage());
            }

            reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            builder = new StringBuilder();
            String response;
            while ((response = reader.readLine()) != null) {
                builder.append(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
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
