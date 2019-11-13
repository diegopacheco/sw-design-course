package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsMain2 {
    public static void main(String[] args) throws Exception {

        Runnable runnableTask = new Runnable(){
            @Override
            public void run() {
                System.out.println("Printing *** ");
            }
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(runnableTask, 0, 1, TimeUnit.SECONDS);
        Thread.sleep(4000L);
        executorService.shutdownNow();
        System.out.println("END");
    }
}

