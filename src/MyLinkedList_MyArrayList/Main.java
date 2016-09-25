package MyLinkedList_MyArrayList;


import java.util.ArrayList;

public class Main {
    static void print_list(MyList<Integer> l) {
        Object[] arr = l.toArray();
        for (Object o : arr) {
            System.out.print(o.toString() + "  ");

        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> l = new MyLinkedList<>();
        MyLinkedList<Integer> l1 = new MyLinkedList<>();
        l1.add(1);
        l1.add(2);
        MyLinkedList<String> l2 = new MyLinkedList<>();
        l2.add("asdasd");
        l2.add("asdasd");
        l.addAll(l1);
       // l.addAll(l2);

        l.add(1);
        l.add(2);
        l.add(3);
        l.remove(2);
        print_list(l);
        System.out.println("l.get(0) = " + l.get(0));
        System.out.println("l.get(1) = " + l.get(1));
        System.out.println("l.get(2) = " + l.get(2));
        System.out.println("l.size() = " + l.size());


//        MyArrayList<Integer> arrayList = new MyArrayList<>();
//        arrayList.add(10);
//        arrayList.add(11);
//        arrayList.add(13);
//        arrayList.add(14);
//        print_list(arrayList);
//        arrayList.set(2, 19);
//        print_list(arrayList);
//        arrayList.add(2, 77);
//        print_list(arrayList);
//        System.out.println("arrayList.size() = " + arrayList.size());
//        System.out.println("arrayList.remove(2) = " + arrayList.remove(2));
//        System.out.println("arrayList.size() = " + arrayList.size());
//
//        print_list(arrayList);
//
//
//        System.out.println(arrayList.indexOf(15));
//
////        MyArrayList<String> arc1 = new MyArrayList<>();
////        arc1.add("asdasd");
////        arc1.add("asdasd");
////        arrayList.addAll(arc1);
//        MyArrayList<Integer> arc2 = new MyArrayList<>();
//        arc2.add(2);
//        arc2.add(3);
//        arrayList.addAll(arc2);
//        print_list(arrayList);




    }

}
