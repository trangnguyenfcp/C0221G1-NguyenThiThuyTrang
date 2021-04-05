package Bai_4_Lop_va_doi_tuong_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_1_Xay_dung_lop_QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập các tham số a, b, c của phương trình bậc 2: a*x*x + b*x + c = 0");
        System.out.println("Nhập a");
        double a = scanner.nextDouble();
        System.out.println("Nhập b");
        double b = scanner.nextDouble();
        System.out.println("Nhập c");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double discriminant = quadraticEquation.getDiscriminant();
        if (discriminant > 0){
            System.out.println("Nghiệm 1 là: " + quadraticEquation.getRoot1());
            System.out.println("Nghiệm 2 là: " + quadraticEquation.getRoot2());
        } else if (discriminant == 0){
            System.out.println("Nghiệm kép là: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("Vô nghiệm");
        }

    }
    public static class QuadraticEquation {
        private double a;
        private double b;
        private double c;

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }

        public QuadraticEquation(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public double getDiscriminant(){
            return b*b - 4*a*c;
        }
        public double getRoot1(){
            return (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
        }
        double getRoot2(){
            return (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
        }

    }
}
