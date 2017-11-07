package ru.otus;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayTest {
    public static  boolean execute(List var) {
        Comparator comp= (Comparator<Integer>) (o1, o2) -> o1.compareTo(o2);
        Class cls=var.getClass();
        List<Integer> a= null;
        List<Integer> c=null;
        try {
            a = (List) cls.newInstance();
            c = (List) cls.newInstance();

        java.util.Collections.addAll(a,3,1,5);
            Integer[] control={3,1,5};
            if(!Arrays.equals(control,a.toArray())){throw new IndexOutOfBoundsException("Add all not true");}

        java.util.Collections.addAll(c,1,2);
        Arrays.sort(control, comp);
        java.util.Collections.sort(a,comp);
            if(!Arrays.equals(control,a.toArray())){throw new IndexOutOfBoundsException("Sort not true");}
        java.util.Collections.copy(a,c);
        control[1]=2;
        if(!Arrays.equals(control,a.toArray())){throw new IndexOutOfBoundsException("Copy not true");}

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
