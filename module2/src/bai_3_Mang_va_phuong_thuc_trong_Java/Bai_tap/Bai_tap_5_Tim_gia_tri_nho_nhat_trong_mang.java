package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_5_Tim_gia_tri_nho_nhat_trong_mang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            System.out.println("Nhập phần tử vị trí: " + i);
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];
        for (int i = 1; i < n; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là: ");
        System.out.println(min);
    }
}
