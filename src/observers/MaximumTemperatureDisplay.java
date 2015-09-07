package observers;

import interfaces.base.Observer;
import interfaces.base.Subject;
import interfaces.display.DisplayElement;

/**
 * This is the class that displays the maimum temperature.
 * Created by Sripadmanaban on 9/6/2015.
 */
public class MaximumTemperatureDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private double temperature;

    public MaximumTemperatureDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double maxTemperature, double minTemperature) {
        this.temperature = maxTemperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("The maximum tenperature is " + temperature);
    }
}
