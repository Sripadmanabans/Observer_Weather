package model.part;

import com.google.gson.annotations.SerializedName;

/**
 * This class contains all the necessary weather data.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class Main {

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

}
