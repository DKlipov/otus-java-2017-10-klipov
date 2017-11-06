package ru.otus;

import java.util.*;

class CustomArrayIterator<T> implements ListIterator<T>{
CustomArrayList<T> CAL;
Integer cursor;
    CustomArrayIterator(CustomArrayList a){
        CAL=a;
        cursor=0;
    }
    @Override
    public boolean hasNext() {
        if(cursor>= CAL.size()){return false;}
        return true;
    }

    @Override
    public T next() {
        cursor=cursor+1;
        return CAL.get(cursor-1);
    }

    @Override
    public boolean hasPrevious() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public T previous() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public int nextIndex() {
        return cursor+1;
    }

    @Override
    public int previousIndex() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public void remove() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public void set(T t) {
        CAL.set(cursor-1,t);
    }

    @Override
    public void add(T t) {
        CAL.add(t);
    }
}

public class CustomArrayList<T> implements List<T> {
    private int length;
    private T[] array;
    CustomArrayList(){
        length=0;
        array= (T[]) new Object[500];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        if (length==0)
            return false;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomArrayIterator<T>(this);
    }

    @Override
    public T[] toArray() {
        T[] newarray= (T[]) new Object[500];
        newarray= Arrays.copyOfRange(array, 0, length);
        return newarray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean add(T t) {
        array[length]=t;
        length+=1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public void clear() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public T get(int index) {
        if(index>=length){throw new IndexOutOfBoundsException(Integer.toString(index));}
        return array[index];

    }

    @Override
    public T set(int index, T element) {
        if(index>=length){throw new IndexOutOfBoundsException(Integer.toString(index));}
        T a=array[index];
        array[index]=element;
        return a;
    }

    @Override
    public void add(int index, T element) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public T remove(int index) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public int indexOf(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public ListIterator<T> listIterator() {
        return new CustomArrayIterator<T>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new IndexOutOfBoundsException("Undefined");
    }
}
