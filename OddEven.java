public class OddEven implements Runnable{

    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    int even;
    int odd;
    static Object lock=new Object();

    OddEven(int remainder)
    {
        this.remainder=remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
//          synchronized
            synchronized (lock) {
                while (number % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
                if(Thread.currentThread().getName()=="Even_Thread") {
                    even ++;
                }
                else if(Thread.currentThread().getName()=="Odd_Thread") {
                    odd ++;
                }
                number++;
                lock.notifyAll();
            }
        }
        System.out.println("Even are = " + even);
        System.out.println("Odd are = " + odd);

    }
}