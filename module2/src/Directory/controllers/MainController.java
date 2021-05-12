package Directory.controllers;

import Directory.commons.EmailException;
import Directory.commons.PhoneNumberException;
import Directory.commons.ReadAndWriteFile;
import Directory.commons.Validators;
import Directory.models.Contact;


import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Contact> contacts = new ArrayList<>();
    public static void main(String[] args) {
        MainController.update();
    }
    public static void displayMainMenu() {
        int function;
        do {
            System.out.println(
                    "----- Directory management program ----\n" +
                            "Please choose function by number to continue: \n" +
                            "1.\tShow Directory\n" +
                            "2.\tAdd New Contact\n" +
                            "3.\tUpdate\n" +
                            "4.\tDelete\n" +
                            "5.\tSearch\n" +
                            "6.\tRead File\n" +
                            "7.\tWrite File\n" +
                            "8.\tExit\n"
            );
            System.out.print("Please choose function: ");
            function = Integer.parseInt(scanner.nextLine());
            switch (function) {
                case 1:
readFile();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
//
                    break;
                case 6:
                        readFile();
                    break;
                case 7:
                    writeFile();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (function != 8);
    }
    public static void addNewContact() {
        System.out.println("Input contact information");
        boolean isValid;
        String phoneNumber;
        do {
            isValid = true;
            System.out.println("Input phone number");
            phoneNumber = scanner.nextLine();
            try {
                Validators.isValidPhoneNumber(phoneNumber);
            } catch (PhoneNumberException e) {
                isValid = false;
                e.printStackTrace();
            }
        } while (!isValid);
        System.out.println("Input contact group");
        String contactGroup = scanner.nextLine();

        System.out.println("Input full name");
        String fullName = scanner.nextLine();

        System.out.println("Input gender");
        String gender = scanner.nextLine();

        System.out.println("Input address");
        String address = scanner.nextLine();

        System.out.println("Input date of birth");
        String dateOfBirth = scanner.nextLine();

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
        contacts.add(new Contact(phoneNumber, contactGroup, fullName, gender, address, dateOfBirth, email));
    }
    public static void writeFile(){
        System.out.println("Do you want to update file? Input 0(Yes) 1 (No)");
        int choice = scanner.nextInt();
        if (choice==0){
        ReadAndWriteFile.setFullPathFile("Contact");
        ReadAndWriteFile.writeFile(contacts);}

    }
    public static void readFile() {
//        System.out.println("Do you want to read file, choose 0(yes) 1 (no)");
//        int choice = scanner.nextInt();

        ReadAndWriteFile.setFullPathFile("Contact");
        List<String> lines = ReadAndWriteFile.readFile();

        for (String line : lines) {
            String[] lineSplit = line.split(",");
            contacts.add(new Contact(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]));
        }
        for (int i =0; i < contacts.size(); i++){
            System.out.println((i+1) +". " + contacts.get(i).toString());
        }
    }
    public static void addUpdateDeleteContact(){
        readFile();
        System.out.println( "1.\tAdd new contact\n" +
                "2.\tPhone Number\n" +
                "3.\tContact Group\n" +
                "4.\tFull name\n" +
                "5.\tGender\n" +
                "6.\tAddress\n");

    }
    public static void delete(){

       readFile();
        System.out.println("Input contact want to delete");
        int choice = scanner.nextInt();
        for (int i = 0; i < contacts.size(); i++){
            if ((i+1)==choice){
                contacts.remove(i);
            }
        }
        for (Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }
    public static void update(){
        readFile();
        System.out.println("Input contact want to update");
        String phoneNum = scanner.nextLine();

        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getPhoneNumber().equals(phoneNum)){
                System.out.println("Input new Phone Number");
                String newPhoneNum = scanner.nextLine();
                contacts.get(i).setPhoneNumber(newPhoneNum);
            }
        }
        for (Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }

}
