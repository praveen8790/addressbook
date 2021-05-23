package org.bridgelabz.addressbook;
import org.bridgelabz.addressbook.controller.Controller;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to addressbook" );
        Controller menu = new Controller();
        int exit_status=0;
        while(exit_status==0) exit_status = menu.menu();

    }
}
