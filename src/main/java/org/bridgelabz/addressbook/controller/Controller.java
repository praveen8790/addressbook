package org.bridgelabz.addressbook.controller;

import org.bridgelabz.addressbook.services.IoServices;
import org.bridgelabz.addressbook.services.Operations;
import org.bridgelabz.addressbook.utility.Person;

import java.util.Scanner;

import static org.bridgelabz.addressbook.services.Operations.addressbook1;

public class Controller {
    public static final Scanner scanner = new Scanner(System.in);
    public int menu1(){
        System.out.println("enter your choice");
        System.out.println("1.add new contact\n"+"2.edit existing contact\n"+"3.delete existing contact\n"+"4.exit\n");
        int option=scanner.nextInt();
        int exit_status = 0;
        IoServices operator = new Operations();
        switch(option){
            case 1:
                operator.add();
                break;
            case 2:
                System.out.println("1.first name\n"+"2.last name\n"+"3.address\n"+"4.city\n"+"5.state\n"+"6.zip\n"+"7.phone number\n"
                        +"8.email");
                int edit_option=scanner.nextInt();
                operator.edit(edit_option);
                break;
            case 3:
                operator.delete();
                break;
            case 4:
                exit_status=1;
                break;
            default:
                System.out.println(addressbook1.toString());

        }
        return exit_status;


    }

}
