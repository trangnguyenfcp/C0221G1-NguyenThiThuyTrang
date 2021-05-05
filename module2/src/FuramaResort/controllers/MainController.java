package FuramaResort.controllers;

import FuramaResort.commons.ReadAndWriteBinaryFile;
import FuramaResort.commons.ReadAndWriteFile;
import FuramaResort.commons.Validators;
import FuramaResort.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainController.displayMainMenu();
    }

    public static void displayMainMenu() {
        int service;
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
                    showServices();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    System.exit(0);
            }
        } while (service != 7);
    }

    public static void addNewServices() {
        int choice;
        do {
            System.out.println(
                    "1.\tAdd New Villa\n" +
                            "2.\tAdd New House\n" +
                            "3.\tAdd New Room\n" +
                            "4.\tBack to menu\n" +
                            "5.\tExit\n"
            );
            System.out.println("Please choose the service you want to add: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    String id = null;
                    do {
                        System.out.print("Enter id: ");
                        id = scanner.nextLine();
                    } while (!Validators.isValidService(id, Validators.SERVICE_ID_REGEX));
                    String services = null;
                    do {
                        System.out.print("Enter service: ");
                        services = scanner.nextLine();
                    } while (!Validators.isValidService(services, Validators.SERVICE_NAME_REGEX));
                    double usableArea;
                    do {
                        System.out.print("Enter usable area: ");
                        usableArea = Double.parseDouble(scanner.nextLine());
                    } while (!Validators.isMoreThan(usableArea, 30));
                    double rentalCost;
                    do {
                        System.out.print("Enter rental cost: ");
                        rentalCost = Double.parseDouble(scanner.nextLine());
                    }while (!Validators.isMoreThan(rentalCost, 0));

                    int maximumInHouse;
                    do {
                        System.out.print("Enter maximum in house: ");
                        maximumInHouse = Integer.parseInt(scanner.nextLine());
                    }while (!Validators.isMoreThan((double) maximumInHouse, 20, 0));
                    String rentalPeriod;
                    do {
                        System.out.print("Enter rental period: ");
                        rentalPeriod = scanner.nextLine();
                    }while (!Validators.isValidService(rentalPeriod, Validators.SERVICE_NAME_REGEX));

                    if (choice == 1) {
                        String standardOfRoom;
                        do {
                            System.out.print("Enter standard of room: ");
                            standardOfRoom = scanner.nextLine();
                        } while (!Validators.isValidService(standardOfRoom, Validators.SERVICE_NAME_REGEX));
                        System.out.print("Enter description other amenities: ");
                        String descriptionOtherAmenities = scanner.nextLine();
                        double swimmingPoolArea;
                        do {
                            System.out.print("Enter swimming pool area: ");
                            swimmingPoolArea = Double.parseDouble(scanner.nextLine());
                        } while (!Validators.isMoreThan(swimmingPoolArea, 30));
                        int numberOfFloors;
                        do {
                          System.out.print("Enter number of floors: ");
                          numberOfFloors = Integer.parseInt(scanner.nextLine());
                      }while (!Validators.isMoreThan((double)numberOfFloors, 0));

                        ReadAndWriteFile.setFullPathFile("Villa");
                        ReadAndWriteFile.writeFile(new String[]{id, services, String.valueOf(usableArea), String.valueOf(rentalCost), String.valueOf(maximumInHouse), rentalPeriod, standardOfRoom, descriptionOtherAmenities, String.valueOf(swimmingPoolArea), String.valueOf(numberOfFloors)});

                    }
                    if (choice == 2) {
                        String standardOfRoom;
                        do {
                            System.out.print("Enter standard of room: ");
                            standardOfRoom = scanner.nextLine();
                        } while (Validators.isValidService(standardOfRoom, Validators.SERVICE_NAME_REGEX));
                        System.out.print("Enter description other amenities: ");
                        String descriptionOtherAmenities = scanner.nextLine();
                        System.out.print("Enter number of floors: ");
                        int numberOfFloors = Integer.parseInt(scanner.nextLine());
                        ReadAndWriteFile.setFullPathFile("House");
                        ReadAndWriteFile.writeFile(new String[]{id, services, String.valueOf(usableArea), String.valueOf(rentalCost), String.valueOf(maximumInHouse), rentalPeriod, standardOfRoom, descriptionOtherAmenities, String.valueOf(numberOfFloors)});
                    }
                    if (choice == 3) {
                        String freeService;
                        do {
                            System.out.print("Enter free service: ");
                            freeService = scanner.nextLine();
                        } while (!Validators.isValidFreeService(freeService));

                        ReadAndWriteFile.setFullPathFile("Room");
                        ReadAndWriteFile.writeFile(new String[]{id, services, String.valueOf(usableArea), String.valueOf(rentalCost), String.valueOf(maximumInHouse), rentalPeriod, freeService});
                    }
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 5);
    }

    public static void showServices() {
        int choice;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("Enter 1 - 8 to show services");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAllVillas();
                    break;
                case 2:
                    showAllHouses();
                    break;
                case 3:
                    showAllRooms();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    displayMainMenu();
                case 8:
                    System.exit(0);
            }

        } while (choice != 8);
    }

    private static void showAllVillas() {
        List<Villa> villas = new ArrayList<>();
        ReadAndWriteFile.setFullPathFile("Villa");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            villas.add(new Villa(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Long.parseLong(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], lineSplit[7], Double.parseDouble(lineSplit[8]), Integer.parseInt(lineSplit[9])));
        }
        for (Villa villa : villas) {
            System.out.println(villa.showInfor());
        }
    }

    private static void showAllHouses() {
        List<House> houses = new ArrayList<>();
        ReadAndWriteFile.setFullPathFile("House");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            houses.add(new House(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Long.parseLong(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], lineSplit[7], Integer.parseInt(lineSplit[9])));
        }
        for (House house : houses) {
            System.out.println(house.showInfor());
        }
    }

    private static void showAllRooms() {
        List<Room> rooms = new ArrayList<>();
        ReadAndWriteFile.setFullPathFile("Room");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            rooms.add(new Room(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Long.parseLong(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6]));
        }
        for (Room room : rooms) {
            System.out.println(room.showInfor());
        }
    }
    public static void addNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input customer information");
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input date of birth");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input id card number");
        String idCard = scanner.nextLine();
        System.out.println("Input phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Input email");
        String email = scanner.nextLine();
        System.out.println("Input type of customer");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("Input address");
        String address = scanner.nextLine();
        ReadAndWriteFile.setFullPathFile("Customer");
        ReadAndWriteFile.writeFile(new String[]{name, dateOfBirth, gender, idCard, phoneNumber, email, typeOfCustomer, address});
    }
    public static void showCustomerInformation(){
        List<Customer> customers = new ArrayList<>();
        ReadAndWriteFile.setFullPathFile("Customer");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            customers.add(new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7], (Services)lineSplit[7]));
        }
        for (Customer customer : customers) {
            System.out.println(customer.showInfor());
        }
    }
}
