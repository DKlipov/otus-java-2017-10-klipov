package ru.otus.HW2;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main( final String[] args ) throws InterruptedException {
        //mn();
        System.gc();
        System.out.println("start");
        Runtime runtime = Runtime.getRuntime();
         long base = runtime.totalMemory();
        int f=2000000;
        String[] a=new String[f];
        for(int i=0;i<f;i++){
            a[i]=new String("");
        }
        System.out.print("String is: ");
        System.out.println((base- runtime.freeMemory())/f);
        System.gc();
            Thread.sleep(2000);
        int[] b=new int[f];
        for(int i=0;i<f;i++){
            b[i]=new Integer(0);
        }
        System.out.print("int is: ");
        System.out.println((base- runtime.freeMemory())/f);
        System.gc();
        Thread.sleep(2000);
        Object[] c=new Object[f];
        for(int i=0;i<f;i++){
            c[i]=new Object();
        }
        System.out.print("Object is: ");
        System.out.println((base- runtime.freeMemory())/f);
        System.gc();
    }


    public static void mn() throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

        System.out.println("Starting the loop");
        while (true) {
            Object[] array = new Object[size];
            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                array[i] = new Object();
                //array[i] = new String(""); //String pool
                //array[i] = new String(new char[0]); //without String pool
                //array[i] = new MyClass();
            }
            System.out.println("Created " + size + " objects.");
            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static class MyClass {
        private int i = 0;
        private long l = 1;
    }
}
