package interfaces.base;

/**
 * This is the interface that all observers have to implement.
 * Created by Sripadmanaban on 9/6/2015.
 */
public interface Observer {

    /**
     * This is the function that gets ccalled when the temperature gets updated.
     *
     * @param temperature    A double that contains the temperature in kelvin.
     * @param maxTemperature A double that contains the maximum temperature in kelvin.
     * @param minTemperature A double that conatins the minimum temperature in kelvin.
     */
    void update(double temperature, double maxTemperature, double minTemperature, int humidity);
}
