package model.parts;

import com.google.gson.annotations.SerializedName;

/**
 * This class contains all the necessary weather data.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class Main {

    private static final double KELVIN_TO_CELSIUS = 273.15;

    @SerializedName("temp")
    private double temp;

    @SerializedName("pressure")
    private long pressure;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("temp_min")
    private double temperatureMinimum;

    @SerializedName("temp_max")
    private double temperatureMaximum;

    public double getTemp() {
        return temp - KELVIN_TO_CELSIUS;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemperatureMinimum() {
        return temperatureMinimum - KELVIN_TO_CELSIUS;
    }

    public double getTemperatureMaximum() {
        return temperatureMaximum - KELVIN_TO_CELSIUS;
    }
}
