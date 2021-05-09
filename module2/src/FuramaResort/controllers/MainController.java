package FuramaResort.controllers;

import Bai_5_Access_modifier_static_method_static_property.Thuc_hanh.pack.A;
import FuramaResort.commons.ReadAndWriteBinaryFile;
import FuramaResort.commons.ReadAndWriteFile;
import FuramaResort.commons.Validators;
import FuramaResort.exception.*;
import FuramaResort.models.*;

import java.time.Year;
import java.util.*;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Customer> customers = new ArrayList<>();
    public static List<House> houses = new ArrayList<>();
    public static List<Villa> villas = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {

       MainController.deleteCustomer();

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
                    showCustomerInformation();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showAllEmployees();
                    break;
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
                    } while (!Validators.isMoreThan(rentalCost, 0));

                    int maximumInHouse;
                    do {
                        System.out.print("Enter maximum in house: ");
                        maximumInHouse = Integer.parseInt(scanner.nextLine());
                    } while (!Validators.isMoreThan((double) maximumInHouse, 20, 0));
                    String rentalPeriod;
                    do {
                        System.out.print("Enter rental period: ");
                        rentalPeriod = scanner.nextLine();
                    } while (!Validators.isValidService(rentalPeriod, Validators.SERVICE_NAME_REGEX));

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
                        } while (!Validators.isMoreThan((double) numberOfFloors, 0));

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
                    showAllNameVillaNotDuplicate();
                    break;
                case 5:
                    showAllNameHouseNotDuplicate();
                    break;
                case 6:
                    showAllNameRoomNotDuplicate();
                    break;
                case 7:
                    displayMainMenu();
                case 8:
                    System.exit(0);
            }

        } while (choice != 8);
    }

    private static void showAllVillas() {
        ReadAndWriteFile.setFullPathFile("Villa");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            villas.add(new Villa(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Double.parseDouble(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], lineSplit[7], Double.parseDouble(lineSplit[8]), Integer.parseInt(lineSplit[9])));
        }
        for (int i =0; i < villas.size(); i++){
            System.out.println((i+1) +". " + villas.get(i).showInfor());
        }
    }

    private static void showAllHouses() {
        ReadAndWriteFile.setFullPathFile("House");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            houses.add(new House(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Long.parseLong(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], lineSplit[7], Integer.parseInt(lineSplit[9])));
        }
        for (int i =0; i < houses.size(); i++){
            System.out.println((i+1) +". " + houses.get(i).showInfor());
        }
    }

    private static void showAllRooms() {
        ReadAndWriteFile.setFullPathFile("Room");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            rooms.add(new Room(lineSplit[0], lineSplit[1], Double.parseDouble(lineSplit[2]), Double.parseDouble(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6]));
        }
        for (int i =0; i < rooms.size(); i++){
            System.out.println((i+1) +". " + rooms.get(i).showInfor());
        }
    }

    public static void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input customer information");
        boolean isValid;
        String name;
        do {
            isValid = true;
            System.out.println("Input name");
            name = scanner.nextLine();
            try {
                Validators.isValidName(name);
            } catch (NameException e) {
                isValid = false;
                e.printStackTrace();
            }
        } while (!isValid);
        String dateOfBirth;
        do {
            isValid = true;
            System.out.println("Input date of birth");
            dateOfBirth = scanner.nextLine();
            try {
                Validators.isValidBirthday(dateOfBirth);
            } catch (BirthdayException e) {
                isValid = false;
                e.printStackTrace();
            }
        } while (!isValid);
        String gender;
        do {
            isValid = true;
            System.out.println("Input gender");
            gender = scanner.nextLine();
            try {
                Validators.isValidGender(gender);
            } catch (GenderException e) {
                isValid = false;
                e.printStackTrace();
            }
            gender = gender.replace(gender.charAt(0), Character.toUpperCase(gender.charAt(0)));
        } while (!isValid);
        String idCard;
        do {
            isValid = true;
            System.out.println("Input id card number");
            idCard = scanner.nextLine();
            try {
                Validators.isValidIdCard(idCard);
            } catch (IdCardException e) {
                isValid = false;
                e.printStackTrace();
            }
        } while (!isValid);

        System.out.println("Input phone number");
        String phoneNumber = scanner.nextLine();
        String email;
        do {
            isValid = true;
            System.out.println("Input email");
            email = scanner.nextLine();
            try {
                Validators.isValidEmail(email);
            } catch (EmailException e) {
                isValid = false;
                e.printStackTrace();
            }
        } while (!isValid);

        System.out.println("Input type of customer");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("Input address");
        String address = scanner.nextLine();
        ReadAndWriteFile.setFullPathFile("Customer");
        ReadAndWriteFile.writeFile(new String[]{name, dateOfBirth, gender, idCard, phoneNumber, email, typeOfCustomer, address});
    }

    public static void showCustomerInformation() {

        ReadAndWriteFile.setFullPathFile("Customer");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            customers.add(new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7],null));
        }
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer customerFirst, Customer customerSencond) {
                int compare = customerFirst.getName().compareTo(customerSencond.getName());
                if (compare == 0) {
                    int year1 = Integer.parseInt(customerFirst.getDateOfBirth().split("/")[2]);
                    int year2 = Integer.parseInt(customerSencond.getDateOfBirth().split("/")[2]);
                    compare = year1 - year2;
                }
                return compare;
            }
        });
        for (int i =0; i < customers.size(); i++){
            System.out.println((i+1) +". " + customers.get(i).showInfor());
        }
    }
    public static void deleteCustomer(){
        showCustomerInformation();
        ReadAndWriteFile.setFullPathFile("Customer");
        System.out.println("Choose customer order number to delete: ");
        int inputOrderNumber = scanner.nextInt();
        ReadAndWriteFile.deleteLine(inputOrderNumber);
    }
    public static void addNewBooking() {
        showCustomerInformation();
        System.out.println("Choose customer order number: ");
        int inputOrderNumber = scanner.nextInt();
        System.out.println("1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        System.out.println("Choose service: ");
        int serviceOrderNumber = scanner.nextInt();
        if (serviceOrderNumber == 1) {
            System.out.println("List villas: ");
           showAllVillas();
            System.out.println("Choose villa ");
            int orderNumberVilla = scanner.nextInt();
           customers.get(inputOrderNumber-1).setServices(villas.get(orderNumberVilla-1));
        } else if (serviceOrderNumber == 2) {
            System.out.println("List houses: ");
            showAllHouses();
            System.out.println("Choose house ");
            int orderNumberHouse = scanner.nextInt();
            customers.get(inputOrderNumber-1).setServices(houses.get(orderNumberHouse-1));
        } else {
            System.out.println("List rooms: ");
            showAllRooms();
            System.out.println("Choose room ");
            int orderNumberRoom = scanner.nextInt();
            customers.get(inputOrderNumber-1).setServices(rooms.get(orderNumberRoom-1));
        }
    ReadAndWriteFile.setFullPathFile("Booking");
        ReadAndWriteFile.writeFile(new String[]{customers.get(inputOrderNumber-1).showInfor()});
    }
    public static void showAllNameVillaNotDuplicate(){
        Set<String> treeSet = new TreeSet();
        for (Villa villa: villas){
            treeSet.add(villa.getService());
        }
        System.out.println("All Name Villa Not Duplicate");
        System.out.println(treeSet);
        displayMainMenu();
    }
    public static void showAllNameHouseNotDuplicate(){
        Set<String> treeSet = new TreeSet();
        for (House house: houses){
            treeSet.add(house.getService());
        }
        System.out.println("All Name House Not Duplicate");
        System.out.println(treeSet);
        displayMainMenu();
    }


    public static void showAllNameRoomNotDuplicate(){
        Set<String> treeSet = new TreeSet();
        for (Room room: rooms){
            treeSet.add(room.getService());
        }
        System.out.println("All Name Room Not Duplicate");
        System.out.println(treeSet);
        displayMainMenu();
    }
    public static void showAllEmployees(){
        List<String> employeeLines = new ArrayList<>();

        Map<String,Employee> employeeMap = new LinkedHashMap<>();
        ReadAndWriteFile.setFullPathFile("Employee");
        employeeLines = ReadAndWriteFile.readFile();
        for(String line:employeeLines){
            String[] lineSplit = line.split(",");
            employees.add(new Employee(lineSplit[0], lineSplit[1], Integer.parseInt(lineSplit[2]), lineSplit[3]));
        }
        for (Employee employee: employees){

            employeeMap.put(employee.getId(), employee);
            System.out.println(employee.toString());
        }

    }
    public static void buyTicket() {
        showCustomerInformation();
        Queue<Customer> queue = new LinkedList<>();
        int orderNumber;
        int choice;
        do {
            System.out.println("Choose customer buy ticket: ");
            orderNumber = Integer.parseInt(scanner.nextLine());
            queue.add(customers.get(orderNumber-1));
            System.out.println("Other customer? 0 (no) or 1 (yes)");
            choice=Integer.parseInt(scanner.nextLine());
        }while (choice!=0);

        for (Customer customer:queue){
            System.out.println(customer.showInfor());
        }
    }
}
