package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.utility.Person;

import java.util.ArrayList;

import static org.bridgelabz.addressbook.controller.Controller.scanner;

public class Operations implements IoServices {
    public static ArrayList<Person> addressbook1 = new ArrayList<Person>();

    public void add(){
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
        addressbook1.add(person_new);
    }
    public void edit(int edit_choice){
        System.out.println("enter the first name of contact");
        String firstname = scanner.next();
        String value = scanner.next();
        addressbook1.forEach(p->{
            if(p.getFirst_name().equalsIgnoreCase(firstname))
                switch (edit_choice){
                    case 1:
                        p.setFirst_name(value);
                        break;
                    case 2:
                        p.setLast_name(value);
                        break;
                    case 3:
                        p.setAddress(value);
                        break;
                    case 4:
                        p.setCity(value);
                        break;
                    case 5:
                        p.setState(value);
                        break;
                    case 6:
                        p.setZip(value);
                        break;
                    case 7:
                        p.setPhone_number(value);
                        break;
                    case 8:
                        p.setEmail(value);
                        break;

                }

        });

    }
    public void delete(){
        System.out.println("............delete menu...........");
        System.out.println("enter the first name of contact");
        String firstname = scanner.next();
        for(int i=0;i< addressbook1.size();i++){
            if(addressbook1.get(i).getFirst_name().equalsIgnoreCase(firstname))
                addressbook1.remove(i);
        }

    }


}
