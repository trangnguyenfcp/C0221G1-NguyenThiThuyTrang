package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class Bai_tap_2_Them_phan_tu_vao_mang {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử mảng: ");
        n = scanner.nextInt();
        int[] array = new int[n+1];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử vị trí: " + i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Nhập gía trị cần chèn");
        int numb = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn");
        int index = scanner.nextInt();
        if (index < 0 || index>n-1) {
            System.out.println("Không chèn được: ");
        } else {
            for (int i = 0; i < n; i++) {
                if (i == index) {
                    for (int j = n-1; j >= index; j--) {
                        array[j+1] = array[j];
                    }
                    array[index] = numb;
                }
            }
            for (int i = 0; i < n+1; i++) {
                System.out.println(array[i] + "\t");
            }
        }
    }
}
