package MyLinkedList_MyArrayList;


import java.util.Collection;

public class MyLinkedList<E> implements MyList<E> {

    private int size = 0;
    private Node<E> first=null;
    private Node<E> last;

    public MyLinkedList() {
    }

    @Override
    public void add(Object e) {
        Node<E> l = last;
        Node<E> newNode = new Node(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next=newNode;
        }
        size++;

    }

    @Override
    public void add(int index, Object element) {
        if(index==size){
            add(element);
        }else{
            Node<E> nodeIndex=node(index);
            Node<E> pred=nodeIndex.prev;
            Node<E> newNode=new Node(pred,element,nodeIndex);
            nodeIndex.prev=newNode;
            if(pred==null){
                first=newNode;
            }else{
                pred.next=newNode;
            }
            size++;
        }
    }

    @Override
    public void addAll(MyList<? extends E> c) {
        Object[] a = c.toArray();
        for (Object o : a) {
            add(o);
        }
    }

    @Override
    public void addAll(int index, MyList<? extends E> c) {
        int indexTemp=index;
        Object[] a = c.toArray();
        for (Object o : a) {
            add(indexTemp,o);
            indexTemp++;
        }

    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public Object remove(int index) {
        Node<E> oldNode=node(index);
        Node<E> next=oldNode.next;
        Node<E> prev=oldNode.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            oldNode.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            oldNode.next = null;
        }

        oldNode.item = null;
        size--;
        return oldNode.item;
    }

    @Override
    public void set(int index, E element) {
        Node<E> nodeNow=node(index);
        nodeNow.item= (E) element;
    }

    @Override
    public int indexOf(Object o) {
        int index=0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result=new Object[size];
        int i=0;
        for (Node<E> x=first;x!=null;x=x.next)
            result[i++]=x.item;
        return result;
    }


    Node<E> node(int index) {
        //start from first or last
        Node<E> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
           x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
