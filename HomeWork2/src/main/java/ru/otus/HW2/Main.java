package ru.otus.HW2;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main( final String[] args ) throws InterruptedException {
        Measure a=new Measure(1000000);
        System.out.print("String is: ");
        System.out.println(a.getValueString());
        Thread.sleep(2000);
        System.out.print("Collection (ArrayList) is: ");
        System.out.println(a.getValueArray());
        Thread.sleep(2000);
        System.out.print("Object is: ");
        System.out.println(a.getValueObject());

    }
}
