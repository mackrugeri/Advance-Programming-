public class Starting {
    public static void main(String[] args) {

        OddEven odd=new OddEven(1);
        OddEven even=new OddEven(0);


//      Generation of Thread
        Thread t1=new Thread(even,"Even_Thread");
        Thread t2=new Thread(odd,"Odd_Thread");

//      Starting thread
        t1.start();
        t2.start();

    }
}