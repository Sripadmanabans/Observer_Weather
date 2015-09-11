import runnable.WeatherAPICall;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * This is the main class that controls flow.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class WeatherControlCenter {

    public static void main(String args[]) {
        WeatherAPICall call = new WeatherAPICall();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        final ScheduledFuture<?> weatherHandle = executorService.scheduleAtFixedRate(call, 0, 2, TimeUnit.SECONDS);
        executorService.schedule(() -> weatherHandle.cancel(true), 8, TimeUnit.SECONDS);
    }
}