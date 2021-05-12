package Directory.commons;


import Directory.models.Contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void writeFile(List<Contact> contacts) {
        try {
            FileWriter fileWriter = new FileWriter(path, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Contact contact:contacts){
                bufferedWriter.write(contact.getPhoneNumber()+ ","+contact.getContactGroup()+","+contact.getFullName()+","+contact.getGender()+","+contact.getAddress()+","+contact.getDateOfBirth()+","+contact.getEmail());
            }
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFullPathFile(String fileName) {
        StringBuffer path = new StringBuffer("D:\\C0221G1-NguyenThiThuyTrang\\module2\\src\\Directory\\data\\");
        path.append(fileName);
        path.append(StringUtils.CSV);
        ReadAndWriteFile.path = path.toString();
    }

    public static void deleteLine(int lineOrder) {
        List<String> customerLines = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                customerLines.add(line);
            }
            FileWriter fileWriter = new FileWriter(path, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < customerLines.size(); i++){
                if ((i+1)!=lineOrder) {
                    bufferedWriter.write(customerLines.get(i));
                    bufferedWriter.newLine();
                }else {
                    bufferedWriter.write("");
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
