package FuramaResort.commons;

import FuramaResort.models.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;
    private static String path;

    public static List<String> readFile() {
        List<String> serviceLines = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                serviceLines.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceLines;
    }

    public static void writeFile(String[] content) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(StringUtils.concat(content, StringUtils.COMMA));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setFullPathFile(String fileName){
        StringBuffer path = new StringBuffer("D:\\C0221G1-NguyenThiThuyTrang\\module2\\src\\FuramaResort\\data\\");
        path.append(fileName);
        path.append(StringUtils.CSV);
        ReadAndWriteFile.path = path.toString();
    }
}