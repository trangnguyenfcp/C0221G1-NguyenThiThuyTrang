package bai_2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienthiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 2;

        while (N < 100){
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(N); i++){
                if (N % i == 0){
                    check = false;
                }
            }
            if (check){
                System.out.println(N);
            }
            N++;
        }

    }
}
