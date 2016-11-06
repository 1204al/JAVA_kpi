package workshop.task_1_2;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class Factorial {


    public static long factorial(long i) {
        // implement function body in order all test to complete successfully
//first variant
        //return LongStream.iterate(1,operand -> operand+1).limit(i).reduce(1,(a,b)->a*b);
                                                                            //(a,b)->a*b    a*=b
//second variant
        return LongStream.rangeClosed(1,i).reduce(1,(a,b)->a*b);




    }
}
