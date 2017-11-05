package ru.otus;

import java.util.*;

public class Main {

    public static void main(String[] args){
        Comparator comp=new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        CustomList<Integer> a=new CustomList<Integer>();
        CustomList<Integer> c=new CustomList<Integer>();
        java.util.Collections.addAll(a,3,1,5);
        java.util.Collections.addAll(c,1,2);
        for(int e : a){
            System.out.print(e+", ");
        }
        System.out.print("\n");

        Object[] aa = a.toArray();
        Arrays.sort(aa, comp);
        ListIterator<Integer> i = a.listIterator();
        for (Object e : aa) {
            i.next();
            i.set((Integer) e);
        }
        java.util.Collections.sort(a,comp);
        for(int e : a){
            System.out.print(e+", ");
        }
        System.out.print("\n");
        java.util.Collections.copy(a,c);
        for(int e : a){
            System.out.print(e+", ");
        }
        System.out.print("\n");
    }


}
