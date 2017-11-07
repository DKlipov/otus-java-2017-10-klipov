package ru.otus;

import java.util.*;

public class Main {

    public static void main(String[] args){
        System.out.println(ArrayTest.execute(new CustomArrayList()));//реализация коллекции на основе масиива
        System.out.println(ArrayTest.execute(new CustomList()));//альтернативная реализация коллекции
        Comparator comp= (Comparator<Integer>) (o1, o2) -> o1.compareTo(o2);
        CustomArrayList<Integer> a=new CustomArrayList<>();
        CustomArrayList<Integer> c=new CustomArrayList<>();
        java.util.Collections.addAll(a,3,1,5);
        java.util.Collections.addAll(c,1,2);
        for(int e : a){
            System.out.print(e+", ");//коллекция после заполнения
        }
        System.out.print("\n");
        java.util.Collections.sort(a,comp);
        for(int e : a){
            System.out.print(e+", ");//коллекция после сортировки
        }
        System.out.print("\n");
        java.util.Collections.copy(a,c);
        for(int e : a){
            System.out.print(e+", ");//коллекция после копирования
        }
        System.out.print("\n");
    }


}
