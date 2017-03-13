package com.myproject.factorial;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 * Created by user on 13.03.2017.
 */
public class factCallable implements Callable<BigInteger> {
    private int start;
    private int end;
    private BigInteger resualt;

    public factCallable(int n1, int n2, BigInteger resualt){
        this.start = n1;
        this.end = n2;
        this.resualt = resualt;
    }

    public BigInteger call() throws Exception {

        BigInteger r = resualt;

        for (int i = start; i <= end; ++i) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r;

    }
}
