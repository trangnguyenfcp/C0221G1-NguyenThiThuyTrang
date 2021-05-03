package ss16_io_text_file.exercise;

import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = new ArrayList<>();
        numbers = readAndWriteFile.readFile("D:\\C0221G1_Nguyen_Thi_Thuy_Trang\\module2\\src\\ss16_io_text_file\\practice\\numbers.txt");
        System.out.println(numbers);
        readAndWriteFile.writeFile(numbers,"D:\\C0221G1_Nguyen_Thi_Thuy_Trang\\module2\\src\\ss16_io_text_file\\practice\\result.txt");
    }
}
