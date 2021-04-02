package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_4_Tim_phan_tu_lon_nhat_trong_mang_2_chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int n = scanner.nextInt();
        System.out.println("Nhập vào số cột: ");
        int m = scanner.nextInt();
        double[][] arr = new double[n][m];
        double max = arr[0][0];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.println("Nhập vào phần tử ở vị trí hàng: " + i +" cột " + j);
                arr[i][j] = scanner.nextDouble();
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất của mảng là : " + max);
    }
}
