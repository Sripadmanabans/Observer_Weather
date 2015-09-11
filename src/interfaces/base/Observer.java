package interfaces.base;

import model.WeatherData;

/**
 * This is the interface that all observers have to implement.
 * Created by Sripadmanaban on 9/6/2015.
 */
public interface Observer {

    /**
     * This is the function that gets ccalled when the temperature gets updated.
     *
     * @param weatherData This is the object that contains all the data to be used to pull from.
     */
    void update(WeatherData weatherData);
}
