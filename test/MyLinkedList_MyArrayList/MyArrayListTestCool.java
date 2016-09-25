package MyLinkedList_MyArrayList;

import MyLinkedList_MyArrayList.MyArrayList;
import org.junit.Test;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class MyArrayListTestCool {
    @Test
    public void testCool1() throws Exception {
        int numSize=1000;
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        assertEquals(arr1.size(), arr2.size());
        int t;
        for (int i = 0; i < numSize; i++) {
            t = i * i - i / 2 + 7;
            arr1.add(t);
            arr2.add(t);
        }
        assertEquals(arr1.size(), arr2.size());
        for (int i = 0; i < numSize; i++) {
            assertEquals(arr1.get(i), arr2.get(i));
        }

        Random random = new Random();
        int indexT;
        int numRemove=10;
        for (int i = 0; i <numRemove; i++) {
            indexT=random.nextInt(10)+20;
            arr1.remove(indexT);
            arr2.remove(indexT);
        }

        for (int i = 0; i < numSize-numRemove; i++) {
            assertEquals(arr1.get(i), arr2.get(i));
        }
    }

    @Test
    public void testCool2() throws Exception {
        int numSize=100;
        ArrayList<Integer> smallArr=new ArrayList<>();
        MyArrayList<Integer> smallMyArr=new MyArrayList<>();
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int t;
        Random random = new Random();
        for (int i = 0; i < numSize; i++) {
            t = random.nextInt(50)+50;
            smallArr.add(t);
            smallMyArr.add(t);
        }
        arr1.addAll(smallMyArr);
        arr2.addAll(smallArr);
        for (int i = 0; i < numSize; i++) {
            assertEquals(arr1.get(i), arr2.get(i));
        }
    }
}