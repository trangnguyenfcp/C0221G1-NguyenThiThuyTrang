package FuramaResort.controllers;

import FuramaResort.models.House;
import FuramaResort.models.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static List<Services> houses = new ArrayList<>();
    static List<Services> rooms = new ArrayList<>();
    static List<Services> villas = new ArrayList<>();
    public void displayMainMenu() {
        int service;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "1.	 Add New Services" + "\n" +
                            "2.	 Show Services " + "\n" +
                            "3.	Add New Customer " + "\n" +
                            "4.	Show Information of Customer " + "\n" +
                            "5.	Add New Booking" + "\n" +
                            "6.	Show Information of Employee" + "\n" +
                            "7.	Exit" + "\n"
            );
            System.out.println("Please choose service");
            service = scanner.nextInt();
            switch (service) {
                case 1:
                    addNewServices();
                    break;
                case 2:
//                    showServices();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.exit(0);
            }
        } while (service != 7);
    }
    public void addNewServices(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "1.\tAdd New Villa\n" +
                            "2.\tAdd New House\n" +
                            "3.\tAdd New Room\n" +
                            "4.\tBack to menu\n" +
                            "5.\tExit\n"
            );
            System.out.println("Please choose the service you want to add: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter id: ");
                    String id = scanner.nextLine();
                    System.out.println(" ");
                    System.out.println("Enter service: ");
                    String services = scanner.nextLine();
                    System.out.println("Enter usable area: ");
                    Double usableArea = scanner.nextDouble();
                    System.out.println("Enter rental cost: ");
                    long rentalCost = scanner.nextLong();
                    System.out.println("Enter maximum in house: ");
                    int maximumInHouse = scanner.nextInt();
                    System.out.println("Enter rental period: ");
                    String rentalPeriod = scanner.nextLine();
                    System.out.println("Enter standard of room: ");
                    System.out.println(" ");
                    String standardOfRoom = scanner.nextLine();
                    System.out.println("Enter description other amenities: ");
                    String descriptionOtherAmenities = scanner.nextLine();
                    System.out.println("Enter number of floors: ");
                    int numberOfFloors = scanner.nextInt();
                    houses.add(new House(id, services, usableArea, rentalCost, maximumInHouse, rentalPeriod, standardOfRoom, descriptionOtherAmenities, numberOfFloors));
                    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
                    readAndWriteFile.writeFile(houses, "D:\\C0221G1_Nguyen_Thi_Thuy_Trang\\module2\\src\\FuramaResort\\data\\House.csv");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    System.exit(0);
            }
        } while (choice!=5);
    }

}
