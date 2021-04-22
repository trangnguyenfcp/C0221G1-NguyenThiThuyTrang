package bai_11_dsa_stack_queue.bai_tap;
import java.util.Stack;
import java.util.Scanner;
public class TransferDecimalToBinary {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Stack<Integer> stack = new Stack();
    int numb;
        System.out.println("Input decimal number: ");
        numb = scanner.nextInt();
        while (numb != 0){
            int surplus = numb % 2;
            stack.push(surplus);
            numb = numb/2;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++){
        result[i] = stack.pop();
            System.out.print(result[i]);
        }
}}
