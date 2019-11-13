package threads;

public class SyncMainFixed{

    static class GlobalSafeCounter{
        private Integer counter = 0;
        public  Integer getCount(){ return counter; }
        public  synchronized Integer inc(){ return ++counter; }
    }

    public static void main(String[] args) throws Exception{
        GlobalSafeCounter counter = new GlobalSafeCounter();
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