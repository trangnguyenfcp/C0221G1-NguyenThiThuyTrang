package FuramaResort.commons;

import FuramaResort.models.House;
import FuramaResort.models.Services;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBinaryFile {
    public List<Services> readFile(String path){
        List<Services> services = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            services = (List<Services>) ois.readObject();
           fis.close();
           ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return services;
    }
    public void writeFile(List<Services> services, String path){
       try{
           FileOutputStream fos = new FileOutputStream(path);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(services);
          fos.close();
          oos.close();
       } catch (Exception e){
           e.printStackTrace();
       }
    }
}
