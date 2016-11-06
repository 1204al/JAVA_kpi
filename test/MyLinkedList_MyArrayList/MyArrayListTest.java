package MyLinkedList_MyArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testAddAll() throws Exception {
        MyArrayList<Integer> smallArr=new MyArrayList<>();
        for (int i = 0; i <10; i++) {
            smallArr.add(i);
        }
        MyArrayList<Number> bigArr=new MyArrayList<>();
        bigArr.add(12);
        bigArr.add(13);
        bigArr.addAll(smallArr);

    }
}