package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_6_Tinh_tong_cac_so_o_mot_cot_xac_dinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int n = scanner.nextInt();
        System.out.println("Nhập vào số cột: ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.println("Nhập vào phần tử ở hàng: " + i + " cột " +j);
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Nhập vào vị trí cột cần tính tổng: ");
        int index = scanner.nextInt();
        int sum = 0;
        if (index <0 || index >= m){
            System.out.println("Nhập sai cột");
        }else {

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (j == index){
                   sum += arr[i][index];
                }
            }
        }}
        System.out.println("Tổng của cột " + index + " là: " + sum);
    }
}
