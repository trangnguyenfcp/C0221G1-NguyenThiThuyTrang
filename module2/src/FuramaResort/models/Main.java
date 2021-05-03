package FuramaResort.models;

public class Main {
    public static void main(String[] args) {
        House house = new House("1", "Hains", 65.23, 75000, 5, "3 thang", "2 phong ngu", "khong",3);
        System.out.println(house.showInfor());
    }
}
