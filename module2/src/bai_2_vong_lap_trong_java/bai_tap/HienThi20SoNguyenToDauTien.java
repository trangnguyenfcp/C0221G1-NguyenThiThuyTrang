package bai_2_vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers;
        numbers = scanner.nextInt();
        int count = 0;
        int N = 2;

        while (count < numbers){
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(N); i++){
                if (N % i == 0){
                    check = false;
                }
            }
            if (check){
                System.out.println(N);
                count++;
            }
            N++;
        }

    }
}
