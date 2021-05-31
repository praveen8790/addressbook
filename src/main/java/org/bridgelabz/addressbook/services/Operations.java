package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.entity.AddressBook;
import org.bridgelabz.addressbook.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.bridgelabz.addressbook.controller.Controller.scanner;

public class Operations implements IoServices{
    public static HashMap<String, AddressBook> multiplebook = new HashMap<String, AddressBook>();


    public void addbooks(String key, AddressBook ad){

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

    public AddressBook add( Person person_new){
        AddressBook addressBook = new AddressBook();
        AtomicInteger flag = new AtomicInteger();
        multiplebook.entrySet().forEach(entry ->{
            entry.getValue().getAddressbooks().forEach(person ->{
                if(person.getFirst_name().equalsIgnoreCase(person_new.getFirst_name()) &&
                        person.getLast_name().equalsIgnoreCase(person_new.getLast_name())){
                    flag.set(1);
                }

            });
        });
        if(flag.get()==0) {


            ArrayList<Person> temp_book = new ArrayList<Person>();
            temp_book.add(person_new);
            addressBook.setAddressbooks(temp_book);
            System.out.println("this is arraylist" + addressBook.addressbooks.toString());
        }
        else{
            System.out.println("contact already exists");
        }
        return addressBook;
    }


    public void edit(String key, int edit_choice){
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

    public void searchByCityOrState(int cityorstate,String value){
        multiplebook.entrySet().forEach(entry ->{
            entry.getValue().getAddressbooks().forEach(person -> {
                        switch (cityorstate){
                            case 1:
                                if(person.getCity().equalsIgnoreCase(value))
                                    System.out.println(person.toString());
                                break;
                            case 2:
                                if(person.getState().equalsIgnoreCase(value))
                                    System.out.println(person.toString());
                                break;
                        }
                    });
                });


    }


}

