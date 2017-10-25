package ru.otus.HW2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Measure{
    int num;
    Runtime runtime;
    public Measure(int n){
        num=n;
        runtime = Runtime.getRuntime();
    }

    public int getValueString(){
        System.gc();
        long l = (runtime.totalMemory() - runtime.freeMemory());
        String[] a = new String[num];
        for(int i=0;i<num;i++){
            a[i]=new String("");
        }
        l = ((runtime.totalMemory() - runtime.freeMemory())-l)/num;
        System.gc();
        return (int)l;
    }
    public int getValueObject(){
        System.gc();
        long l = (runtime.totalMemory() - runtime.freeMemory());
        Object[] a = new Object[num];
        for(int i=0;i<num;i++){
            a[i]=new Object();
        }
        l = ((runtime.totalMemory() - runtime.freeMemory())-l)/num;
        System.gc();
        return (int)l;
    }
    public int getValueArray(){
        System.gc();
        long l = (runtime.totalMemory() - runtime.freeMemory());
        ArrayList[] a = new ArrayList[num];
        for(int i=0;i<num;i++){
            a[i]=new ArrayList();
        }
        l = ((runtime.totalMemory() - runtime.freeMemory())-l)/num;
        System.gc();
        return (int)l;
    }
}
