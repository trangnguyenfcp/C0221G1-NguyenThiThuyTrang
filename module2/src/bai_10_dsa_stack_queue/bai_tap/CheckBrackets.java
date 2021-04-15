package bai_10_dsa_stack_queue.bai_tap;
import java.util.Scanner;
import java.util.Stack;
public class CheckBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        String inputString;
        System.out.println("Input expression: ");
        inputString = scanner.nextLine();
        for (int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == '('){
                stack.push(')');
            }
            if (inputString.charAt(i) == ')'){
                if (stack.empty()){
                    System.out.println(false);
                    return;
                }
                stack.pop();
            }
        }
        if (stack.empty()){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
