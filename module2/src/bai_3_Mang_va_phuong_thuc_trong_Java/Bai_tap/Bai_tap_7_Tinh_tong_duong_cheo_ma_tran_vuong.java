package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_7_Tinh_tong_duong_cheo_ma_tran_vuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng cũng như số cột: ");
        int n = scanner.nextInt();
        double[][] arr = new double[n][n];
        double sum = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.println("Nhập phần tử ở hàng " + i + " cột " +j);
                arr[i][j] = scanner.nextDouble();
                if (i == j){
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các phần tử đường chéo chính: " + sum);
    }

}
