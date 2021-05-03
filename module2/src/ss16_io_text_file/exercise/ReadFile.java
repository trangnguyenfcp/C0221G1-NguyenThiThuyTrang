package ss16_io_text_file.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<String> readFile(String filePath){
        List<String> nationLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                nationLine.add(line);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return nationLine;
    }
}
