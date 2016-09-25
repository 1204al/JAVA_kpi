package MyLinkedList_MyArrayList;


import java.util.Collection;

public interface MyList<E> {
    void add(E e);
    void add(int index, E element);
    void addAll(MyList<? extends E> c);
    void addAll(int index, MyList<? extends E> c) ;
    E get(int index) ;
    Object remove(int index);
    void set(int index, E element);

    int indexOf(E o) ;

    int size() ;
    Object[] toArray() ;

}
