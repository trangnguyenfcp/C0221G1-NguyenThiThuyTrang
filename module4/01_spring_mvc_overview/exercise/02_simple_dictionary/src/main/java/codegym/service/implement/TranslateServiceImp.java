package codegym.service.implement;

import codegym.service.TranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TranslateServiceImp implements TranslateService {
    public static Map<String, String> dictionary = new HashMap<String, String>();
    static {
        dictionary.put("cat", "mèo");
        dictionary.put("dog", "chó");
        dictionary.put("go", "đi");
    }
    @Override
    public String translateFromEnglish(String word) {
        String result = "Not found";
        for (Map.Entry<String, String> entry:dictionary.entrySet()){
            if (word.equals(entry.getKey())){
                result = entry.getValue();
            }
        }
        return result;
    }

    @Override
    public String translateFromVietnamese(String word) {
        String result = "Not found";
        for (Map.Entry<String, String> entry:dictionary.entrySet()){
            if (word.equals(entry.getValue())){
                result = entry.getKey();
            }
        }
        return result;
    }
}
