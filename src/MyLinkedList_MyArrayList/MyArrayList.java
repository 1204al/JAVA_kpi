package MyLinkedList_MyArrayList;


import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> implements MyList<E>, RandomAccess {
    public Object[] elementData;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 2;
    private void checkAndRangeCapacity(){
        if (size == capacity) {
            capacity *= 2;
            Object[] newElementData = new Object[capacity];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            elementData = newElementData;
        }
    }
    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.elementData = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E e) {
        checkAndRangeCapacity();
        elementData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkAndRangeCapacity();
        System.arraycopy(elementData, index, elementData, index + 1,size - index);
        elementData[index] = element;
        size++;

    }

    @Override
    public void addAll(MyList<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    @Override
    public void addAll(int index, MyList<? extends E> c) {
        for (int i = 0; i < c.size(); i++) {
            add(index,c.get(i));
            index++;
        }


    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public Object remove(int index) {
        Object t=elementData[index];
        size--;
        System.arraycopy(elementData, index+1, elementData, index,size-index);
        return t;
    }

    @Override
    public void set(int index, Object element) {
        elementData[index]=element;

    }

    @Override
    public int indexOf(Object o) {
        E[] a = (E[]) this.elementData;
        for (int i = 0; i < a.length; i++)
            if (o.equals(a[i]))
                return i;

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
}
