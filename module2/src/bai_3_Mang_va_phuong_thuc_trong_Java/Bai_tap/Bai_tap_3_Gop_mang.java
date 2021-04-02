package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_3_Gop_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập kích thước mảng 1: ");
        int n1 = scanner.nextInt();
        System.out.println("Nhập kích thước mảng 2: ");
        int n2 = scanner.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] arr3 = new int[n1+n2];
        for (int i = 0; i < n1; i++){
            System.out.println("Nhập phần tử mảng 1 ở vị trí: " + i);
            arr1[i] = scanner.nextInt();
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++){
            System.out.println("Nhập phần tử mảng 2 ở vị trí: " + i);
            arr2[i] = scanner.nextInt();
            for (int j = n1+i; j < n1+n2; j++){
            arr3[j] = arr2[i];
        }}
        System.out.println("Mảng 3 là: ");
        for (int i = 0; i < n1 + n2; i++){
            System.out.print(arr3[i] + "\t");
        }
    }
}
