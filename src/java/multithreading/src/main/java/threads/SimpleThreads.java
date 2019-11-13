package threads;

public class SimpleThreads{
    public static void main(String[] args) throws Exception{
        
        Runnable myCode = new Runnable(){
            @Override
            public void run() {
                System.out.println("Running " +  Thread.currentThread().getName());
                System.out.println("DONE");
            }
        };

        Thread t = new Thread(myCode);
        t.setName("My-First-Thread");
        t.start();
        t.join();
    }
}

