package com.myproject.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by user on 13.03.2017.
 */
public class MainThead {
    public static void main(String[] args){

        int factorialNum  = 10;
        int threadsCount = 4;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter value of the calculate factorial (default 10) : ");
        factorialNum = in.nextInt();
        System.out.print("Enter number of threads to calculate (default 2) : ");
        threadsCount = in.nextInt();

        int stepValueFactorialToThreads = factorialNum/threadsCount;
        int startValueFactorialToThreads = 0;
        int endValueFactorialToThreads = 0;
        BigInteger factorial = BigInteger.ONE;


        long beginTime = System.currentTimeMillis();
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<BigInteger>> result = new ArrayList<Future<BigInteger>>();
        for (int i = 0; i < threadsCount; i ++ ){
            startValueFactorialToThreads = (stepValueFactorialToThreads*i)+1;
            endValueFactorialToThreads = stepValueFactorialToThreads*(i+1);
            if (i == (threadsCount-1)&&( endValueFactorialToThreads != factorialNum)){
                endValueFactorialToThreads = factorialNum;
            }
            System.out.println("( "+ startValueFactorialToThreads+ "- "+ endValueFactorialToThreads + " )");

            result.add(exec.submit(new FactorialUtil(startValueFactorialToThreads, endValueFactorialToThreads, BigInteger.ONE)));
        }

        for (Future<BigInteger> bigIntegerFuture : result) {
            try {
                factorial = factorial.multiply(bigIntegerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.print("Результут вычисления "+factorialNum+"! = ");
        System.out.println(factorial.toString());

        System.out.println("Время вычисления  "+ (endTime - beginTime));

    }
}
