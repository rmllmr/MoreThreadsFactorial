package com.myproject.factorial;

import java.math.BigInteger;

/**
 * Created by user on 13.03.2017.
 */
public class MainThead {
    public static void main(String[] args){

        FactorialTree launch = new FactorialTree();
        launch.setFactorialNum(20);
        launch.setThreadsCount(2);

        for (int i =0 ; i < 2 ; i++){
            Thread thread = new Thread(launch);
            thread.start();
        }

        //System.out.println(launch.getFactorialResualt());


    }
}
