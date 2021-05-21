package org.bridgelabz.addressbook;

import org.bridgelabz.addressbook.controller.Controller;
import org.bridgelabz.addressbook.controller.Program;
import org.bridgelabz.addressbook.service.AddContact;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        AddContact newcontact = new AddContact();
        newcontact.addContact();
    }
}
