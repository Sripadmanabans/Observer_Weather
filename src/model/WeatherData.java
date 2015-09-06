package model;

import com.google.gson.annotations.SerializedName;
import interfaces.base.Observer;
import interfaces.base.Subject;
import model.parts.*;

import java.util.ArrayList;

/**
 * This class holds the response for the api.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;

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

    public WeatherData() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int position = observers.indexOf(observer);
        if(position != -1) {
            observers.remove(position);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update(main.getTemp(), main.getTemperatureMaximum(), main.getTemperatureMinimum());
        }
    }

    /**
     * This is the function that is called to notify the change.
     */
    public void measurementsChanged() {
        notifyObserver();
    }
}