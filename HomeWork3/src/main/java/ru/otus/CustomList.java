package ru.otus;

import java.util.*;


class CustomIterator<T> implements ListIterator<T> {
    final CustomValue<T> base;
    CustomValue<T> current;
    Integer cursor;

    CustomIterator(CustomValue<T> a) {
        base = a;
        current = new CustomValue<T>(null);
        current.next = base;
        cursor = 0;
    }

    public boolean hasNext() {
        return current.hasNext();
    }

    public T next() {
        current = current.next;
        cursor++;
        return current.value;
    }

    public boolean hasPrevious() {
        if (current == base) {
            return false;
        }
        return true;
    }

    public T previous() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public int nextIndex() {
        return cursor;
    }

    public int previousIndex() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public void remove() {

    }

    public void set(T t) {
        current.value = t;
    }

    public void add(T t) {
        base.add(t);
    }
}

class CustomValue<T> {
    T value;
    CustomValue<T> next;

    CustomValue(T base) {
        value = base;
        next = null;
    }

    boolean hasNext() {
        if (next == null) {
            return false;
        }
        return true;
    }

    void add(T nt) {
        if (hasNext()) {
            next.add(nt);
        } else {
            next = new CustomValue<T>(nt);
        }
    }

}


public class CustomList<T> implements List<T> {

    Integer size;
    CustomValue<T> value;

    CustomList() {
        size = 0;
        value = new CustomValue<T>(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean contains(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public Iterator<T> iterator() {
        return new CustomIterator<T>(value);
    }

    public T[] toArray() {
        Object[] mass = new Object[size];
        ListIterator<T> it = listIterator();
        int i = 0;
        while (it.hasNext()) {
            mass[i] = it.next();
            i++;
        }
        return (T[]) mass;
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean add(T t) {
        if (isEmpty()) {
            value.value = t;
        } else {
            value.add(t);
        }
        size = size + 1;
        return true;
    }

    public boolean remove(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean containsAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean removeAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public boolean retainAll(Collection<?> c) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public void clear() {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public T get(int index) {
        CustomValue<T> ret = value;
        if (ret == null) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            if (!ret.hasNext()) {
                return null;
            }
            ret = ret.next;
        }
        return ret.value;
    }

    public T set(int index, T element) {
        CustomValue<T> ret = value;
        if (ret == null) {
            value = new CustomValue<T>(null);
            ret = value;
        }
        for (int i = 0; i < index; i++) {
            if (!ret.hasNext()) {
                ret.next = new CustomValue<T>(null);
            }
            ret = ret.next;
        }
        ret.value = element;
        return element;
    }

    public void add(int index, T element) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public T remove(int index) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public int indexOf(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }


    public int lastIndexOf(Object o) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public ListIterator<T> listIterator() {
        return new CustomIterator<T>(value);
    }

    public ListIterator<T> listIterator(int index) {
        throw new IndexOutOfBoundsException("Undefined");
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new IndexOutOfBoundsException("Undefined");
    }
}
