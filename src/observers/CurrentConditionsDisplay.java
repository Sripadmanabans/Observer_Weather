package observers;

import interfaces.base.Observer;
import interfaces.base.Subject;
import interfaces.display.DisplayElement;
import model.WeatherData;

/**
 * This is the class that is used to display the current temperature
 * Created by Sripadmanaban on 9/6/2015.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private double temperature;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double maxTemperature, double minTemperature) {
        this.temperature = temperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("The tenperature is " + temperature);
    }
}
