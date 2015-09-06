package model;

import com.google.gson.annotations.SerializedName;
import model.parts.*;

import java.util.ArrayList;

/**
 * This class holds the response for the api.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class WeatherData {

    @SerializedName("coord")
    private Coordinates coordinates;

    @SerializedName("weather")
    private ArrayList<Weather> weathers;

    @SerializedName("base")
    private String baseStation;

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("dt")
    private long date;

    @SerializedName("sys")
    private SystemDetails systemDetails;

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String cityName;

    @SerializedName("cod")
    private int cod;

}
