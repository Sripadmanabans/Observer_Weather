import runnable.WeatherAPICall;

/**
 * This is the main class that controls flow.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class WeatherControlCenter {

    public static void main(String args[]) {
        WeatherAPICall call = new WeatherAPICall();
        Thread thread = new Thread(call);

        thread.start();
    }

}
