package org.bridgelabz.addressbook.service;

import java.util.Scanner;

import static org.bridgelabz.addressbook.Main.scanner;
import static org.bridgelabz.addressbook.entity.Entity.*;


public class AddContact {

    public void addContact(){
        System.out.println("enter the details:");
        System.out.println("enter first name\n");
        String temp = scanner.next();
        first_name.add(temp);
        System.out.println("enter last name");
        temp = scanner.next();
        last_name.add(temp);
        System.out.println("enter address");
        address.add(scanner.next());
        System.out.println("enter city");
        city.add(scanner.next());
        System.out.println("enter state");
        state.add(scanner.next());
        System.out.println("enter Zip");
        zip.add(scanner.next());
        System.out.println("enter Phone number");
        phone_number.add(scanner.next());
        System.out.println("enter email");
        email.add(scanner.next());

    }
}
