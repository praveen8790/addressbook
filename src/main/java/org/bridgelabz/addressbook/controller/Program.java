package org.bridgelabz.addressbook.controller;

import org.bridgelabz.addressbook.service.*;

import static org.bridgelabz.addressbook.Main.scanner;
public class Program implements Controller{
    public int menu1(){
        System.out.println("enter your choice");
        System.out.println("1.add new contact\n"+"2.edit existing contact\n"+"3.delete existing contact\n"+"4.exit\n");
        int option=scanner.nextInt();
        int exit_status = 0;
        SearchName search = new SearchName();
        Program program = new Program();
        switch(option){
            case 1:
                AddContact newcontact = new AddContact();
                newcontact.addContact();
                break;
            case 2:
                program.menu2(search.searchable());
                break;
            case 3:
                program.menu3(search.searchable());
                break;
            case 4:
                exit_status=1;
                break;
            default:
                program.menu5(search.searchable());

        }
        return exit_status;
    }
    public void menu2(int location){
        if(location>=0){
            System.out.println("please select the modification code");
            System.out.println("1.first name\n"+"2.last name\n"+"3.address\n"+"4.city\n"+"5.state\n"+"6.zip\n"+"7.phone number\n"
                                +"8.email");
            int option=scanner.nextInt();
            String newvalue = scanner.next();
            switch (option){
                case 1:
                    EditContact.setFirstname(location,newvalue);
                    break;
                case 2:
                    EditContact.setLastname(location,newvalue);
                    break;
                case 3:
                    EditContact.setAddress(location,newvalue);
                    break;
                case 4:
                    EditContact.setCity(location,newvalue);
                    break;
                case 5:
                    EditContact.setState(location,newvalue);
                    break;
                case 6:
                    EditContact.setZip(location,newvalue);
                    break;
                case 7:
                    EditContact.setPhoneNumber(location,newvalue);
                    break;
                case 8:
                    EditContact.setEmail(location,newvalue);
                    break;
            }

        }

    }
    public void menu3(int location){
        DeleteContact delete = new DeleteContact();
        delete.delete(location);
        System.out.println("contact successfully deleted");
    }
    public void menu5(int location){
        System.out.println(ReadContact.getFirstname(location));
        System.out.println(ReadContact.getlastname(location));
        System.out.println(ReadContact.getAddress(location));
        System.out.println(ReadContact.getCity(location));
        System.out.println(ReadContact.getState(location));
        System.out.println(ReadContact.getZip(location));
        System.out.println(ReadContact.getPhoneNumber(location));
        System.out.println(ReadContact.getEmail(location));
    }
}
