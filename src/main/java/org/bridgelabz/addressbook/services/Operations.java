package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.utility.AddressBook;
import org.bridgelabz.addressbook.utility.Person;

import java.util.ArrayList;
import java.util.HashMap;

import static org.bridgelabz.addressbook.controller.Controller.scanner;

public class Operations {
    public static HashMap<String, AddressBook> multiplebook = new HashMap<String, AddressBook>();


    public void addbooks(String key, AddressBook ad){
        System.out.println(ad.toString());
        if(multiplebook.containsKey(key)){
                AddressBook temps= new AddressBook();
                temps=multiplebook.get(key);
            for (Person allperson : ad.getAddressbooks()) {
                temps.getAddressbooks().add(allperson);
            }
                multiplebook.put(key,temps);
            }
        else{
            AddressBook temps1= new AddressBook();
            for (Person allperson : ad.getAddressbooks()) {
                temps1.getAddressbooks().add(allperson);
            }
            multiplebook.put(key,temps1);
        }

    }

    public void print(){
        multiplebook.entrySet().forEach( entry -> {
            System.out.println( entry.getKey() + " => " + entry.getValue().addressbooks.toString() );
        });
    }

    public AddressBook add(){
        AddressBook addressBook = new AddressBook();
        ArrayList<Person> temp_book = new ArrayList<Person>();
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
        temp_book.add(person_new);
        addressBook.setAddressbooks(temp_book);
        System.out.println("this is arraylist"+addressBook.addressbooks.toString());
        return addressBook;
    }
    public void edit(String key,int edit_choice){
        System.out.println("enter the first name of contact");
        String firstname = scanner.next();
        String value = scanner.next();
        for(int i=0;i<multiplebook.get(key).getAddressbooks().size();i++) {
            if (multiplebook.get(key).getAddressbooks().get(i).getFirst_name().equalsIgnoreCase(firstname))
                switch (edit_choice) {
                    case 1:
                        multiplebook.get(key).getAddressbooks().get(i).setFirst_name(value);
                        break;
                    case 2:
                        multiplebook.get(key).getAddressbooks().get(i).setLast_name(value);
                        break;
                    case 3:
                        multiplebook.get(key).getAddressbooks().get(i).setAddress(value);
                        break;
                    case 4:
                        multiplebook.get(key).getAddressbooks().get(i).setCity(value);
                        break;
                    case 5:
                        multiplebook.get(key).getAddressbooks().get(i).setState(value);
                        break;
                    case 6:
                        multiplebook.get(key).getAddressbooks().get(i).setZip(value);
                        break;
                    case 7:
                        multiplebook.get(key).getAddressbooks().get(i).setPhone_number(value);
                        break;
                    case 8:
                        multiplebook.get(key).getAddressbooks().get(i).setEmail(value);
                        break;

                }
        }
    }
    public void deletePerson(String key) {
        System.out.println("enter the first name of contact");
        String firstname = scanner.next();
        for (int i = 0; i < multiplebook.get(key).getAddressbooks().size(); i++) {
            if (multiplebook.get(key).getAddressbooks().get(i).getFirst_name().equalsIgnoreCase(firstname))
                multiplebook.get(key).getAddressbooks().remove(i);
        }
    }
    public void showBooks(){
        System.out.println(multiplebook.keySet());
    }
    public void printbook(String key){
        System.out.println(multiplebook.get(key).addressbooks.toString());
    }


    }

