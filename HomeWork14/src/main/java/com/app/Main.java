package com.app;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int numElements=10000;
        int numThreads=4;
        Integer[] sortMs=new Integer[numElements];
        for(int i=0;i<numElements;i++){
            sortMs[i]= (int)(Math.random()*1000000);
        }

        long time;
        Integer[] newMs;

        newMs=sortMs.clone();
        time=System.nanoTime();
        Arrays.sort(newMs);
        System.out.print((System.nanoTime()-time)/1000000);
        System.out.println(" quick sorting");

        newMs=sortMs.clone();
        time=System.nanoTime();
        Arrays.parallelSort(newMs);
        System.out.print((System.nanoTime()-time)/1000000);
        System.out.println(" utils parallel sorting");

        newMs=sortMs.clone();
        time=System.nanoTime();
        ParallelSorter.sort(newMs,numThreads);
        System.out.print((System.nanoTime()-time)/1000000);
        System.out.println(" handmade Parallel sorting");

        newMs=sortMs.clone();
        time=System.nanoTime();
        ParallelSorter.serialSort(newMs);
        System.out.print((System.nanoTime()-time)/1000000);
        System.out.println(" one thread sorting");

    }
}
