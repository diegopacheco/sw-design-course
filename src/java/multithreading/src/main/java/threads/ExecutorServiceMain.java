package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceMain{

    static class GlobalSafeCounter{
        private AtomicInteger counter = new AtomicInteger(0);
        public  Integer getCount(){ return counter.get(); }
        public  Integer inc(){ return counter.incrementAndGet(); }
    }

    public static void main(String[] args) throws Exception{    
        GlobalSafeCounter counter = new GlobalSafeCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            executorService.submit(() -> counter.inc());
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final count is : " + counter.getCount());
    }
}

