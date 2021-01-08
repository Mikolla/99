public class muThreads
{
    public static void main(String[] args) throws InterruptedException
    {
        Tred t1 = new Tred();
        t1.setName("t1");
        Tred t2 = new Tred();
        t2.setName("t2");
        Tred t3 = new Tred();
        t3.setName("t3");

        /*t1.start();
        t1.join();
        t2.join();
        t2.start();
        t3.join();
        t3.start();*/

        //t3.join();
        t3.start();
        t2.join();
        //t2.start();
        t1.join();
        //t1.start();


    }

}

class Tred extends Thread
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep((long)(1000 * Math.random()));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("work " + Thread.currentThread().getName());
    }
}
