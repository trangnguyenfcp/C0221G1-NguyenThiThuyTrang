package ss16_io_text_file.practice;

import java.util.List;
import java.util.Scanner;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        System.out.println("Nhập đường dẫn");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        List<Integer> numbers = readAndWriteFile.readFile(filePath);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\C0221G1_Nguyen_Thi_Thuy_Trang\\module2\\src\\ss16_io_text_file\\practice\\result.txt", maxValue);
    }
}
