package org.bridgelabz.addressbook.service;

import static org.bridgelabz.addressbook.entity.Entity.*;

public class EditContact {
    public static void setFirstname(int location, String newvalue) {
        first_name.set(location, newvalue);
        System.out.println(ReadContact.getFirstname(location));
    }

    public static void setLastname(int location, String newvalue) {
        last_name.set(location, newvalue);
        System.out.println(ReadContact.getlastname(location));

    }

    public static void setAddress(int location, String newvalue) {
        address.set(location, newvalue);
        System.out.println(ReadContact.getAddress(location));
    }

    public static void setCity(int location, String newvalue) {
        city.set(location, newvalue);
        System.out.println(ReadContact.getCity(location));
    }

    public static void setState(int location, String newvalue) {
        state.set(location, newvalue);
        System.out.println(ReadContact.getState(location));
    }

    public static void setZip(int location, String newvalue) {
        zip.set(location, newvalue);
        System.out.println(ReadContact.getZip(location));
    }

    public static void setPhoneNumber(int location, String newvalue) {
        phone_number.set(location, newvalue);
        System.out.println(ReadContact.getPhoneNumber(location));
    }

    public static void setEmail(int location, String newvalue) {
        email.set(location, newvalue);
        System.out.println(ReadContact.getEmail(location));
    }
}
