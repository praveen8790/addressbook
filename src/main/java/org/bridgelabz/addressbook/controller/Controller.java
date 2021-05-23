package org.bridgelabz.addressbook.controller;

import org.bridgelabz.addressbook.services.IoServices;
import org.bridgelabz.addressbook.services.Operations;
import org.bridgelabz.addressbook.utility.Person;

import java.util.Scanner;

import static org.bridgelabz.addressbook.services.Operations.multiplebook;


public class Controller {
    public IoServices operator = new Operations();
    public static final Scanner scanner = new Scanner(System.in);

    public int menu(){
        int exit_status = 0;
        System.out.println("enter number corresponding to ur choice");
        System.out.println("1.add new addressbook\n"+"2.view and choose available addressbooks\n"+"3.print all addressbooks\n"+"4.exit");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("enter name for address book");
                String key=scanner.next();
                operator.addbooks(key, operator.add());
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
                exit_status=1;
                break;


        }
        return  exit_status;
    }
    public int menu1(String key){
        System.out.println("..............................addressbook:"+key+"...............................");
        System.out.println("enter your choice");
        System.out.println("1.add new contact\n"+"2.edit existing contact\n"+"3.delete existing contact\n"+"4.print theis addressbook\n"+"5.exit");
        int option=scanner.nextInt();
        int exit_status1 = 0;

        switch(option){
            case 0:

            case 1:
                operator.addbooks(key, operator.add());


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
                exit_status1=1;
                break;



        }
        return exit_status1;


    }

}
