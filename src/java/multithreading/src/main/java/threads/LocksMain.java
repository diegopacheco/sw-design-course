package threads;

import java.util.concurrent.locks.ReentrantLock;

public class LocksMain{

    static class GlobalSafeCounterWithLocks{
        ReentrantLock lock = new ReentrantLock();
        private Integer counter = 0;
        public  Integer getCount(){ return counter; }
        public  Integer inc(){ 
            lock.lock();
            try {
                return ++counter;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        GlobalSafeCounterWithLocks counter = new GlobalSafeCounterWithLocks();
        Runnable code = new Runnable(){
            @Override
            public void run() { 
                for(int i=1;i<=10;i++){
                    System.out.println("Tread " + Thread.currentThread().getName() + " = " + 
                    counter.inc());     
                }
            }
        };
        Thread t1 = new Thread(code,"t1");
        Thread t2 = new Thread(code,"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();        
    }
}

