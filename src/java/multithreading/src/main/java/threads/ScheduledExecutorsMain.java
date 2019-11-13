package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsMain {
    public static void main(String[] args) throws Exception{

        Callable<String> callableTask = new Callable<String>() {
               @Override
               public String call() throws Exception {
                   System.out.println("Printing *** ");
                   return "Printing *** ";
               } 
        };

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Future<String> resultFuture = executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
        System.out.println("After 1 sec Delay - we got: " + resultFuture.get());
        executorService.shutdown();
    }
}