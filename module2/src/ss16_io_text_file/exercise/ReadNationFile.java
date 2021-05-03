package ss16_io_text_file.exercise;

import java.util.ArrayList;
import java.util.List;

public class ReadNationFile {
    public static void main(String[] args) {
        List<Nations> nationsList = new ArrayList<Nations>();
        ReadFile readFile = new ReadFile();
        List<String> listLine = readFile.readFile("D:\\C0221G1_Nguyen_Thi_Thuy_Trang\\module2\\src\\ss16_io_text_file\\exercise\\nations.csv");
        for (String line : listLine){
            String[] lineSplit = line.split(",");
            Nations nation = new Nations(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
            nationsList.add(nation);
        }
        for (Nations nation : nationsList){
            System.out.println(nation.getId() + "," + nation.getAbbreviationName() + "," + nation.getNationName());
        }

    }
}
