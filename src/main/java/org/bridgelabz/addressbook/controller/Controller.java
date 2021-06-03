package org.bridgelabz.addressbook.controller;

import org.bridgelabz.addressbook.entity.AddressBook;
import org.bridgelabz.addressbook.services.IoServices;
import org.bridgelabz.addressbook.services.Operations;
import org.bridgelabz.addressbook.entity.Person;

import java.util.Scanner;

import static org.bridgelabz.addressbook.services.Operations.multiplebook;


public class Controller {
    public IoServices operator = new Operations();
    public static final Scanner scanner = new Scanner(System.in);

    public int menu(){
        int exit_status = 0;
        System.out.println("enter number corresponding to ur choice");
        System.out.println("1.add new addressbook\n"+"2.view and choose available addressbooks\n"+"3.print all addressbooks\n"+
                "4. Search by city or state\n"+"5.get count by city or state\n"+"6.exit");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("enter name for address book");
                String key=scanner.next();
                operator.addbooks(key, new AddressBook());
                break;
            case 2:
                int exit_status1=0;
                System.out.println("the address books available are");
                operator.showBooks();
                System.out.println("type addressbook name to go into the addressbook");
                String opted_key=scanner.next();

                if(multiplebook.containsKey(opted_key))
                    while(exit_status1==0){
                        exit_status1=menu1(opted_key);
                    }
                break;
            case 3:
                operator.print();
                break;
            case 4:
                System.out.println("1.search by city\n2.search by state");
                int cityorstate = scanner.nextInt();
                System.out.println("enter the name of city or state");
                String value = scanner.next();
                operator.dictionaryByCityORState();
                operator.searchByCityOrState(cityorstate,value);
                break;
            case 5:
                System.out.println("enter \n1. city\n 2.state");
                int temp = scanner.nextInt();
                System.out.println("enter the value");
                String temp1= scanner.next();
                operator.getCountByCityState(temp,temp1);
            case 6:
                exit_status=1;
                break;
        }
        return  exit_status;
    }
    public int menu1(String key){
        System.out.println("..............................addressbook:"+key+"...............................");
        System.out.println("enter your choice");
        System.out.println("1.add new contact\n"+"2.edit existing contact\n"+"3.delete existing contact\n"+
                "4.print this addressbook\n"+"5.Sort by name"+"6.back");
        int option=scanner.nextInt();
        int exit_status1 = 0;

        switch(option){
            case 0:

            case 1:
                Person person_new = new Person();
                System.out.println("enter details of new contact");
                System.out.println("enter first name:");
                person_new.first_name = scanner.next();
                System.out.println("Enter Last Name");
                person_new.last_name= scanner.next();
                System.out.println("Enter address");
                person_new.address= scanner.next();
                System.out.println("Enter City");
                person_new.city= scanner.next();
                System.out.println("Enter State");
                person_new.state= scanner.next();
                System.out.println("Enter Zip Code");
                person_new.zip=scanner.next();
                System.out.println("Enter Phone Number");
                person_new.phone_number = scanner.next();
                System.out.println("Enter Email");
                person_new.email= scanner.next();
                operator.addbooks(key, operator.add(person_new));
                break;
            case 2:
                System.out.println("1.first name\n"+"2.last name\n"+"3.address\n"+"4.city\n"+"5.state\n"+"6.zip\n"+"7.phone number\n"
                        +"8.email");
                int edit_option=scanner.nextInt();
                operator.edit(key,edit_option);
                break;
            case 3:
                operator.deletePerson(key);
                break;
            case 4:
                operator.printbook(key);
                break;
            case 5:
                operator.sortByName();
                break;

            case 6:
                exit_status1=1;
                break;



        }
        return exit_status1;


    }

}
