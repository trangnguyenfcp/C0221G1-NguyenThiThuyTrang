package FuramaResort.models;

import FuramaResort.controllers.MainController;

import java.util.Scanner;
import java.util.Stack;

public class FileCabinets{
    public static void main(String[] args) {
        MainController.showAllEmployees();
        FileCabinets.findFile();
    }
public static void findFile(){
    Scanner scanner = new Scanner(System.in);
    Stack<Employee> fileCabinets = new Stack<>();
    int isFile=0;
    Employee profile;
    for (Employee employee: (MainController.employees)){
        fileCabinets.push(employee);
    }
    do {
        if (fileCabinets.empty()){
            System.out.println("No your profile");
            isFile=0;
        }else {
            profile = fileCabinets.peek();
            System.out.println("------------------------------------");
            System.out.println(profile.toString());
            System.out.println("Is this your profile? 0(Yes) or 1(No)");
            isFile = scanner.nextInt();
            if (isFile == 0) {
                System.out.println("This is your profile: " + profile.toString());
            } else {
                fileCabinets.pop();
            }
        }
    }while (isFile!=0);

}

}
