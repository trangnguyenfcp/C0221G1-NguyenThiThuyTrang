package bai_11_dsa_stack_queue.bai_tap;
import java.util.*;
public class CountWords {
    public static void main(String[] args) {
        TreeMap<Character, Integer > treeMap = new TreeMap<Character, Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input story");
        String story = scanner.nextLine().toLowerCase();
        for (int i = 0; i < story.length(); i++){
            if (treeMap.containsKey(story.charAt(i))){
                treeMap.put(story.charAt(i), treeMap.get(story.charAt(i)) + 1);

            } else {
                treeMap.put(story.charAt(i), 1);
            }
        }
        treeMap.remove(' ');
        Set<Character> keySet = treeMap.keySet();
        for (Character word : keySet){
            System.out.println(word + " - " + treeMap.get(word));
        }
    }
}
