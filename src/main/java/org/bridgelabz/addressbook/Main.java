package org.bridgelabz.addressbook;

import org.bridgelabz.addressbook.controller.Controller;
import org.bridgelabz.addressbook.controller.Program;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Controller menu = new Program();
        int exit_status=0;
        while(exit_status==0) exit_status = menu.menu1();
    }
}
