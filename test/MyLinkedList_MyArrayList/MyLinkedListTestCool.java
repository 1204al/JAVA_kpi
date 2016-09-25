package MyLinkedList_MyArrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

public class MyLinkedListTestCool {
    @Test
    public void testCool1() throws Exception {
        int numSize=10000;
        MyLinkedList<Integer> l1 = new MyLinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        assertEquals(l1.size(), l2.size());
        int t;
        for (int i = 0; i < numSize; i++) {
            t = i * i - i / 2 + 7;
            l1.add(t);
            l2.add(t);
        }
        assertEquals(l1.size(), l2.size());
        for (int i = 0; i < numSize; i++) {
            assertEquals(l1.get(i), l2.get(i));
        }

        Random random = new Random();
        int indexT;
        int numRemove=10;
        for (int i = 0; i <numRemove; i++) {
            indexT=random.nextInt(10)+20;
            l1.remove(indexT);
            l2.remove(indexT);
        }

        for (int i = 0; i < numSize-numRemove; i++) {
            assertEquals(l1.get(i), l2.get(i));
        }
    }

    @Test
    public void testCool2() throws Exception {
        int numSize=10000;
        MyLinkedList <Integer> smallMyLinkedList = new MyLinkedList<>();
        LinkedList<Integer> smallLinkedList = new LinkedList<>();
        MyLinkedList<Integer> l1 = new MyLinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        int t;
        Random random = new Random();
        for (int i = 0; i < numSize; i++) {
            t = random.nextInt(50)+50;
            smallMyLinkedList.add(t);
            smallLinkedList.add(t);

        }
        l1.addAll(smallMyLinkedList);
        l2.addAll(smallLinkedList);

        for (int i = 0; i < numSize; i++) {
            assertEquals(l1.get(i), l2.get(i));
        }


    }
}