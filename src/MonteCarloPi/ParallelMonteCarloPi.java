package MonteCarloPi;


import java.util.ArrayList;
import java.util.List;
class FindPi{
    static int numIn=0;

    class FindPiThread extends Thread{
        final static int num=10000000*5/5 ;
        String name;
        public FindPiThread(String s) {
            this.name=s;
        }

        @Override
        public void run() {
            super.run();
            double x,y;
            for (int i = 0; i < num; i++) {
                x=Math.random();
                y=Math.random();
                if(Math.sqrt(x*x+y*y)<=1) numIn++;
//                System.out.println(name);
//                try {
//                    Thread.currentThread().sleep(4);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }


        }

    }

    public FindPi(int num) throws InterruptedException {
        List<FindPiThread> list=new ArrayList<>();
        for (int i = 0; i < num; i++) {
           list.add(new FindPiThread("Thread"+Integer.toString(i)));
        }
        long start = System.currentTimeMillis();


        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
            System.out.println(i);
        }


      for (int i = 0; i < list.size(); i++) {
          list.get(i).join();
      }

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        int iterations=num* FindPiThread.num;
        System.out.println("numIn = " + numIn);
        System.out.println("Pi = " + 4.*numIn/(1.*iterations));
        System.out.println("THREADS  = " + num);
        System.out.println("Iterations = " + iterations);
        System.out.println("Time = " + timeConsumedMillis);

    }
}


public class ParallelMonteCarloPi {


    public static void main(String[] args) throws InterruptedException {
        FindPi fp=new FindPi(5);
    }
}
