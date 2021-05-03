package bai_15_exception_debug.bai_tap;
import java.util.*;
public class Triangle {
    private static int a, b,c ;
    public  static void triangle(int a, int b, int c) throws IllegalTriangleException{
        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalTriangleException("side > 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a){
            throw new IllegalTriangleException("side1 + side 2 > side3");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input side a");
                int a = Integer.parseInt(scanner.nextLine());
                System.out.println("Input side b");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println("Input side c");
                int c = Integer.parseInt(scanner.nextLine());
                triangle(a, b, c);
                break;
            } catch (IllegalTriangleException e) {
                e.getMessage();
            } catch (NumberFormatException e){
                System.out.println("side: int");
            }
        }
    }
}
