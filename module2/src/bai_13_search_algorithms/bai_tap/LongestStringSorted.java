package bai_13_search_algorithms.bai_tap;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestStringSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        System.out.println("Enter a string: ");
        inputString = scanner.nextLine();
        List<Character> res = new LinkedList<>();
        res.add(inputString.charAt(0));
        int index = 0;
        for (int i = 1; i < inputString.length(); i++){
            if ((int) res.get(index) < inputString.charAt(i)){
                res.add(inputString.charAt(i));
                index++;
            }else {
                res.clear();
                res.add(inputString.charAt(i));
                index = 0;
            }
        }
        for (Character ch:res){
            System.out.print(ch);
        }


    }
}
