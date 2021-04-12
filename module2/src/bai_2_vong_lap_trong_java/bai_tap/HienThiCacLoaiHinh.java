package bai_2_vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        while (choice != 4){

            switch (choice){
                case 1:
                    System.out.println("* * * * * * *\n" +
                            "* * * * * * *\n" +
                            "* * * * * * *");
                    break;
                case 2:
                    System.out.println("*\n" +
                            "* *\n" +
                            "* * *\n" +
                            "* * * *\n" +
                            "* * * * *");
                case 3:
                    System.out.println("* * * * *                             \n" +
                            "* * * *                                   \n" +
                            "* * *                                         \n" +
                            "* *                                               \n" +
                            "*");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
            }
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
        }
    }
}
