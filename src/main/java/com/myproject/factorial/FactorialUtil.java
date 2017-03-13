package com.myproject.factorial;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 * Created by user on 13.03.2017.
 */
public class FactorialUtil implements Callable<BigInteger> {
    private int start;
    private int end;
    private BigInteger result;

    public FactorialUtil(int n1, int n2, BigInteger result){
        this.start = n1;
        this.end = n2;
        this.result = result;
    }

    public BigInteger call() throws Exception {

        BigInteger r = result;

        for (int i = start; i <= end; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r;

    }
}
