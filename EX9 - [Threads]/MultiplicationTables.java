package EX11;

class MultiplicationTask implements Runnable
{
    private int number;
    private final Object lock;

    public MultiplicationTask(int number, Object lock)
    {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run()
    {
        // This synchronized block ensures only one thread
        // can run this code at a time.
        synchronized (lock)
        {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " : -----> Starting Multiplication Table for " + number + " <-----");

            for(int i = 1; i <= 10; i++)
            {
                int product = number * i;

                System.out.println(threadName + " " + number + " X " + i + " = " + product);

                try
                {
                    long sleepTime = (long) (Math.random() * 100 + 10);
                    Thread.sleep(sleepTime);
                }
                catch (InterruptedException e)
                {
                    System.err.println(threadName + ": Thread was interrupted.");
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(threadName + " : -----> Finishing Multiplication Table for " + number + " <-----");
        } // Lock is released here
    }
}

public class MultiplicationTables
{
    public static void main(String args[])
    {
        int num1 = 2;
        int num2 = 7;
        int num3 = 18;

        // Create one shared lock object
        final Object tableLock = new Object();

        // Pass the same lock to all tasks
        Runnable task1 = new MultiplicationTask(num1, tableLock);
        Runnable task2 = new MultiplicationTask(num2, tableLock);
        Runnable task3 = new MultiplicationTask(num3, tableLock);

        Thread t1 = new Thread(task1, "Thread-Table-2 : ");
        Thread t2 = new Thread(task2, "Thread-Table-7 : ");
        Thread t3 = new Thread(task3, "Thread-Table-18 : ");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main : All threads have finished. Exiting...");
    }
}