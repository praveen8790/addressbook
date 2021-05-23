package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.utility.AddressBook;

public interface IoServices {
    void addbooks(String key, AddressBook ad);
    AddressBook add();
    void print();
    void edit(String key,int edit_choice);
    void deletePerson(String key);
    void showBooks();
    void printbook(String key);
}
