package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.entity.AddressBook;
import org.bridgelabz.addressbook.entity.Person;

public interface IoServices {
    void addbooks(String key, AddressBook ad);
    AddressBook add(Person person_new);
    void print();


    void edit(String key, int edit_choice);
    void deletePerson(String key);
    void showBooks();
    void printbook(String key);
    void searchByCityOrState(int cityorstate,String value);
}
