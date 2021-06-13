package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.entity.AddressBook;
import org.bridgelabz.addressbook.entity.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.bridgelabz.addressbook.controller.Controller.scanner;

public class Operations {
    public static HashMap<String, AddressBook> multiplebook = new HashMap<String, AddressBook>();
    public static HashMap<String, ArrayList<Person>> bookbycity = new HashMap<>();
    public static HashMap<String, ArrayList<Person>> bookbystate = new HashMap<>();


    public void addbooks(String key,AddressBook ad){

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
        /*multiplebook.entrySet().forEach(entry ->{
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
                });*/
        switch (cityorstate){
            case 1:
                bookbycity.get(value).forEach(person -> {
                    System.out.println(person.toString());
                });
                break;
            case 2:
                bookbystate.get(value).forEach(person -> {
                    System.out.println(person.toString());
                });
        }
    }

    public void sortByName(){
        Person person = new Person();
       /* multiplebook.entrySet().forEach(entry ->{
            entry.getValue().getAddressbooks().stream().sorted(Comparator.comparing(Person::getFirst_name)).forEach(s->{
                System.out.println(s.first_name);
            });
        });*/
        ArrayList <Person> temp = new ArrayList<>();
        multiplebook.entrySet().stream().map(Map.Entry::getValue)
                .map(AddressBook::getAddressbooks).
                forEach(people -> people.stream().sorted(Comparator.comparing(Person::getFirst_name).thenComparing(Person::getLast_name)).forEach(System.out::println));

                        /*sorted(Comparator.comparing(Person::getFirst_name)).forEach(System.out::println));
                forEach(people -> people.stream().map(Person::getAddress).collect(Collectors.toList()));*/
        /*multiplebook.entrySet().stream().map(Map.Entry::getValue)
                .map(AddressBook::getAddressbooks).
                forEach(people -> people.stream().forEach(person1 -> temp.add(person1)));
        System.out.println(temp.size());
        temp.forEach(person1 -> System.out.println(person1.toString()));*/
    }

    public void sortByCityStateZip(int option){
        switch (option){
            case 1:
                multiplebook.entrySet().stream().map(Map.Entry::getValue)
                        .map(AddressBook::getAddressbooks).
                        forEach(people -> people.stream().sorted(Comparator.comparing(Person::getCity)).forEach(System.out::println));
                break;
            case 2:
                multiplebook.entrySet().stream().map(Map.Entry::getValue)
                        .map(AddressBook::getAddressbooks).
                        forEach(people -> people.stream().sorted(Comparator.comparing(Person::getState)).forEach(System.out::println));
                break;
            case 3:
                multiplebook.entrySet().stream().map(Map.Entry::getValue)
                        .map(AddressBook::getAddressbooks).
                        forEach(people -> people.stream().sorted(Comparator.comparing(Person::getZip)).forEach(System.out::println));
                break;
        }
    }

    public void dictionaryByCityORState(){
        multiplebook.entrySet().forEach(entry -> {
            entry.getValue().getAddressbooks().forEach(person ->{
                if(bookbycity.containsKey(person.getCity())){
                    ArrayList<Person> temps= new ArrayList<>();
                    temps=bookbycity.get(person.getCity());
                    temps.add(person);
                    bookbycity.put(person.getCity(),temps);
                }
                else{
                    ArrayList<Person> temps1= new ArrayList<>();
                    temps1.add(person);
                    bookbycity.put(person.getCity(),temps1);
                }
                if(bookbystate.containsKey(person.getState())){
                    ArrayList<Person> temps= new ArrayList<>();
                    temps=bookbystate.get(person.getState());
                    temps.add(person);
                    bookbystate.put(person.getState(),temps);
                }
                else{
                    ArrayList<Person> temps1= new ArrayList<>();
                    temps1.add(person);
                    bookbystate.put(person.getState(),temps1);
                }
            });
        });
    }

    public int getCountByCityState(int cityorstate,String key){
        switch (cityorstate){
            case 1:
                return bookbycity.get(key).size();
            case 2:
                return bookbystate.get(key).size();
        }
        return 0;
    }

    public void writeDataToFile() throws IOException {
        StringBuffer buffer = new StringBuffer();
        multiplebook.entrySet().stream().forEach(stringAddressBookEntry -> {
            String data ="<" + stringAddressBookEntry.getKey()+'\n';
            buffer.append(data);
            stringAddressBookEntry.getValue().getAddressbooks().forEach(person -> {
                String data1 = person.toString();
                buffer.append(data1);
            });
            data = stringAddressBookEntry.getKey() +">";
            buffer.append(data);
        });
        File myfile = new File("C:\\Users\\prave\\IdeaProjects\\addressbook\\src\\main\\assets\\praveen.txt");
        System.out.println(myfile.getAbsolutePath());
        FileWriter fileWriter = new FileWriter(myfile);
        fileWriter.write(String.valueOf(buffer));
        fileWriter.close();
    }

    public void readData() throws FileNotFoundException {
        File myfile = new File("C:\\Users\\prave\\IdeaProjects\\addressbook\\src\\main\\assets\\praveen.txt");
        Scanner reader =new Scanner(myfile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }

}

