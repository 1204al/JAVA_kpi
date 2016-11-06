package MonteCarloPi;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

class FindPi{
    static int numIn=0;

    class FindPiThread extends Thread{
        final static int num=1000000 ;
        String name;
        private CountDownLatch latch;
        public FindPiThread(String s,CountDownLatch latch) {

            this.name=s;
            this.latch=latch;
        }

        @Override
        public void run() {
            super.run();
            double x,y;
            for (int i = 0; i < num; i++) {
              //  x= ThreadLocalRandom.current().nextDouble();
              //  y= ThreadLocalRandom.current().nextDouble();
               x=Math.random();
                y=Math.random();
                if(Math.sqrt(x*x+y*y)<=1) numIn++;
              // System.out.println(name);
//                try {
//                    Thread.currentThread().sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            latch.countDown();

        }

    }

    public FindPi(int num) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(num);
        CountDownLatch latch=new CountDownLatch(num);
        FindPiThread[] runnables=new FindPiThread[num];

        Arrays.setAll(runnables,n->new FindPiThread("Thread",latch));
        long start = System.currentTimeMillis();

        for(FindPiThread p:runnables){
            executorService.execute(p);
        }
        latch.await();
//        List<FindPiThread> list=new ArrayList<>();
//        for (int i = 0; i < num; i++) {
//           list.add(new FindPiThread("Thread"+Integer.toString(i)));
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).start();
//            System.out.println("thread "+i+"  started");
//        }
//      for (int i = 0; i < list.size(); i++) {
//          list.get(i).join();
//      }

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        int iterations=num* FindPiThread.num;
        System.out.println("numIn = " + numIn);
        System.out.println("Pi = " + 4.*numIn/(1.*iterations));
        System.out.println("THREADS  = " + num);
        System.out.println("Iterations = " + iterations);
        System.out.println("Time = " + timeConsumedMillis+" ms");

    }
}


public class ParallelMonteCarloPi {


    public static void main(String[] args) throws InterruptedException {
        FindPi fp=new FindPi(20);
    }
}
