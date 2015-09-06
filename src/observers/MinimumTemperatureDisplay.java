package observers;

import interfaces.base.Observer;
import interfaces.base.Subject;
import interfaces.display.DisplayElement;

/**
 * This is the class that is used to display the minimum temperature.
 * Created by Sripadmanaban on 9/6/2015.
 */
public class MinimumTemperatureDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private double temperature;

    public MinimumTemperatureDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double maxTemperature, double minTemperature) {
        this.temperature = minTemperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("The maximum tenperature is " + temperature);
    }
}
