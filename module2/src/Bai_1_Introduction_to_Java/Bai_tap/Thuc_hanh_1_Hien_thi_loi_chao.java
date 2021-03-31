package Bai_1_Introduction_to_Java.Bai_tap;
import java.util.Scanner;
public class Thuc_hanh_1_Hien_thi_loi_chao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
