package FuramaResort.controllers;

import FuramaResort.commons.ReadAndWriteFile;
import FuramaResort.models.House;
import FuramaResort.models.Services;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static List<Services> houses = new ArrayList<>();
    private static List<Services> rooms = new ArrayList<>();
    private static List<Services> villas = new ArrayList<>();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter id: ");
//        String id = scanner.nextLine();
//        System.out.print("Enter service: ");
//        String services = scanner.nextLine();
//        System.out.print("Enter usable area: ");
//        double usableArea = Double.parseDouble(scanner.nextLine());
//        System.out.print("Enter rental cost: ");
//        long rentalCost = Long.parseLong(scanner.nextLine());
//        System.out.print("Enter maximum in house: ");
//        int maximumInHouse = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter rental period: ");
//        String rentalPeriod = scanner.nextLine();
//        System.out.print("Enter standard of room: ");
//        String standardOfRoom = scanner.nextLine();
//        System.out.print("Enter description other amenities: ");
//        String descriptionOtherAmenities = scanner.nextLine();
//        System.out.print("Enter number of floors: ");
//        int numberOfFloors = Integer.parseInt(scanner.nextLine());
//        houses.add(new House(id, services, usableArea, rentalCost, maximumInHouse, rentalPeriod, standardOfRoom, descriptionOtherAmenities, numberOfFloors));
        houses.add(new House("1", "house1", 34.5, 300, 4, "3 months", "no", "no", 5));
        System.out.println(houses.get(0).showInfor());
       ReadAndWriteFile.setFullPathFile("House");
       ReadAndWriteFile.writeFile(new String[]{"1", "house1", "34.5", "300", "4", "3 months", "no", "no", "5"});

    }
}
