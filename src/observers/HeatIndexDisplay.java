package observers;

import interfaces.base.Observer;
import interfaces.display.DisplayElement;
import model.WeatherData;

/**
 * This is the class that shows the heat index.
 * Created by Sripadmanaban on 9/11/2015.
 */
public class HeatIndexDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private double temperature;
    private int humidity;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double maxTemperature, double minTemperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        float heatIndex = computeHeatIndex((float) ((temperature * 1.8) + 32), humidity);
        System.out.println("Heat Index : " + (heatIndex - 32) / 1.8 );
    }

    private float computeHeatIndex(float t, float rh) {
        return (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
    }
}
