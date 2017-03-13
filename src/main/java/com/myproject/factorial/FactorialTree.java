package com.myproject.factorial;

import java.math.BigInteger;

/**
 * Created by user on 13.03.2017.
 */
public class FactorialTree implements Runnable{

    private int threadsCount = 1;
    private static int taskCount = 0;
    private int factorialNum = 10;
    private BigInteger factorialResualt = BigInteger.ONE;
    private final int id = taskCount++;

    public FactorialTree(){}
    public FactorialTree(int threadsCount, int factorialNum){
        this.threadsCount = threadsCount;
        this.factorialNum = factorialNum;
    }

    public void setFactorialNum(int factorialNum){
        this.factorialNum = factorialNum;
    }
    public void setThreadsCount(int threadsCount){
        this.threadsCount = threadsCount;
    }

    public BigInteger getFactorialResualt() {
        return factorialResualt;
    }

    static BigInteger factorialNaive(int n1, int n2){
        BigInteger r = BigInteger.valueOf(n1);
        for (int i = n1; i <= n2; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r;
    }

    public void run() {
        int koef = this.factorialNum/this.threadsCount;
        int start = (koef*id)+1;
        int end = koef*(id+1);
        System.out.println(taskCount);
        factorialResualt = factorialResualt.multiply(factorialNaive(start, end));
        System.out.println("#"+ id+ " (" + start+ ","+ end + ") "+ factorialResualt.toString());

    }
}
