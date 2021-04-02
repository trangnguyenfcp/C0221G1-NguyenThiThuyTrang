package bai_3_Mang_va_phuong_thuc_trong_Java.Thuc_hanh;

public class Thuc_hanh_4_Tim_gia_tri_nho_nhat_trong_mang_su_dung_phuong_thuc {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
    public static int minValue(int[] array){
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++){
            if (min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
