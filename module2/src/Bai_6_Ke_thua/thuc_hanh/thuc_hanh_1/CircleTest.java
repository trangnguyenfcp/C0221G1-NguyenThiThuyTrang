package Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
        circle.resize(0.3);
        System.out.println(circle);
    }
}
