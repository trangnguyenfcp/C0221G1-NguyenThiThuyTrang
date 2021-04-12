package bai_7_dsa_danhsach.bai_tap;

public class MyLinkedlistTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<Integer>(3);
        ll.addFirst(6);
        ll.add(1,2);
        ll.add(1,0);
        ll.add(1,1);
        ll.add(1,0);
        ll.addLast(9);
        ll.remove(6);
        ll.printList();
        System.out.println(ll.contains(10));
    }
}
