package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class Bai_tap_1_Xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử mảng: ");
        n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử vị trí: " + i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Nhập phần tử cần xóa");
        int numb = scanner.nextInt();
        int index = 0;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            if (array[i] == numb) {
                index = i;
                for (int j = index; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = 0;
                check = true;
            }
        }
        if (!check) {
            System.out.println("Không có phần tử bằng: " + numb);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(array[i] + "\t");
            }
        }
    }
}
