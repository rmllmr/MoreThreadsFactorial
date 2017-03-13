package com.myproject.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by user on 13.03.2017.
 */
public class MainThead {
    public static void main(String[] args){

 //       FactorialTree launch = new FactorialTree();
 //       launch.setFactorialNum(20);
 //       launch.setThreadsCount(2);
        int factorialNum  = 20;
        int threadsCount = 4;
        int koef = factorialNum/threadsCount;
        int start = 0;
        int end = 0;
        BigInteger factorial = BigInteger.ONE;


        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<BigInteger>> resault = new ArrayList<Future<BigInteger>>();
        for (int i = 0; i < threadsCount; i ++ ){
            start = (koef*i)+1;
            end = koef*(i+1);
            System.out.println("( "+ start+ "- "+ end+ " )");

            resault.add(exec.submit(new factCallable(start, end, BigInteger.ONE)));
        }

        for (Future<BigInteger> bigIntegerFuture : resault) {
            try {
                factorial = factorial.multiply(bigIntegerFuture.get());
                System.out.println(bigIntegerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(factorial.toString());


    }
}
