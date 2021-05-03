package ss16_io_text_file.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String sourceFilePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(sourceFilePath);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

       return numbers;

    }
    public void writeFile(List<Integer> numbers, String targetFilePath){
        try {
            FileWriter fileWriter = new FileWriter(targetFilePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int numb : numbers){
                bufferedWriter.write(String.valueOf(numb));

            }
            bufferedWriter.write("Số ký tự là: " + numbers.size());
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
