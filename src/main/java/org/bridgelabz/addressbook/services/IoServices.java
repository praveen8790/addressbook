package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.entity.AddressBook;
import org.bridgelabz.addressbook.entity.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface IoServices {
    void addbooks(String key, AddressBook ad);
    AddressBook add(Person person_new);
    void print();


    void edit(String key, int edit_choice);
    void deletePerson(String key);
    void showBooks();
    void printbook(String key);
    void searchByCityOrState(int cityorstate,String value);
    void dictionaryByCityORState();
    int getCountByCityState(int cityorstate,String key);
    void sortByName();
    void sortByCityStateZip(int option);
    void writeDataToFile() throws IOException ;
    void readData() throws FileNotFoundException;
    void writeCSV() throws IOException;
    void CSVRead() throws IOException;

}
