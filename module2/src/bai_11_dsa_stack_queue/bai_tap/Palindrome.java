package bai_11_dsa_stack_queue.bai_tap;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Character> queue = new LinkedList();
        Stack<Character> stack = new Stack<>();
        String inputString;
        char[] reverseString = new char[queue.size()];
        System.out.println("Input string: ");
        inputString = scanner.nextLine().toUpperCase();
        for (int i = 0; i < inputString.length(); i++){
            queue.add(inputString.charAt(i));
            stack.push(inputString.charAt(i));
        }
        for (int i = 0; i < inputString.length(); i++){
            if (stack.pop() != queue.remove()){
                System.out.println(false);
                return;
            }
        }
        if (stack.empty()){
            System.out.println(true);
        }
    }
}
