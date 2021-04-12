package bai_7_dsa_danhsach.bai_tap;

public class MyListTest {
    public static void main(String[] args) {
        MyList <Integer> listInteger = new MyList<Integer>(10);
        listInteger.add(0,0);
        listInteger.add(1,2);
        listInteger.add(2,0);
        listInteger.add(3,0);
        System.out.println(listInteger.indexOf(2));
        listInteger.clear();
        System.out.println(listInteger.get(1));

    }

}
