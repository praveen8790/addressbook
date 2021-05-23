package org.bridgelabz.addressbook.services;

import org.bridgelabz.addressbook.utility.AddressBook;

public interface IoServices {
    AddressBook add();
    void edit(int choice);
    void delete();
}
