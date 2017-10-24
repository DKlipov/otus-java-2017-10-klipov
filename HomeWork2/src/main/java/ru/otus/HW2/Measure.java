package ru.otus.HW2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Measure{
    long base;
    int num;
    Runtime runtime;
    public Measure(int n){
        num=n;
        runtime = Runtime.getRuntime();
        base = runtime.totalMemory();
    }

    public int getValueString(){
        System.gc();
        String[] a = new String[num];
        for(int i=0;i<num;i++){
            a[i]=new String("");
        }
        long l=(base- runtime.freeMemory())/num;
        System.gc();
        return (int)l;
    }
    public int getValueObject(){
        System.gc();
        Object[] a = new Object[num];
        for(int i=0;i<num;i++){
            a[i]=new Object();
        }
        long l=(base- runtime.freeMemory())/num;
        System.gc();
        return (int)l;
    }
    public int getValueArray(){
        System.gc();
        ArrayList[] a = new ArrayList[num];
        for(int i=0;i<num;i++){
            a[i]=new ArrayList();
        }
        long l=(base- runtime.freeMemory())/num;
        System.gc();
        return (int)l;
    }
}
