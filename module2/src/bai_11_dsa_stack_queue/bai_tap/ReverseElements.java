package bai_11_dsa_stack_queue.bai_tap;

import java.util.Stack;
import java.util.Scanner;

public class ReverseElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        int size;
        do {
            System.out.println("Enter the size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("size <= 20");
            }

        } while (size > 20);
        int[] array = new int[size];
        int i = 0;
        while (i < size){
            System.out.println("Enter element: " + i);
            array[i] = scanner.nextInt();
            stack.push(array[i]);
            i++;
        }
        for (int index = 0; index < size; index++){
            array[index] = stack.pop();
            System.out.println(array[index]);
        }
    }
}
