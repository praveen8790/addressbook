package org.bridgelabz.addressbook;
import org.bridgelabz.addressbook.controller.Controller;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Welcome to addressbook" );
        Controller menu = new Controller();
        int exit_status=0;
        while(exit_status==0) exit_status = menu.menu();

    }
}
