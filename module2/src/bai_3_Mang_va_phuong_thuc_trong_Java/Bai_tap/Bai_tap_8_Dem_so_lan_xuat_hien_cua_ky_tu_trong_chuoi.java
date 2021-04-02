package bai_3_Mang_va_phuong_thuc_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_8_Dem_so_lan_xuat_hien_cua_ky_tu_trong_chuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String s = scanner.nextLine();
        System.out.println("Nhập ký tự cần đếm: ");
        char a = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (a == s.charAt(i)){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự " + a + " trong chuỗi " + s);
        System.out.println(count);
    }
}
