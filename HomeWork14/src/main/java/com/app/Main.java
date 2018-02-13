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
        
        ParallelSorter.sort(sortMs,numThreads);

    }
}
