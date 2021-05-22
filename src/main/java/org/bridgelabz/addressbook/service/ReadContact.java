package org.bridgelabz.addressbook.service;

import static org.bridgelabz.addressbook.entity.Entity.*;
import static org.bridgelabz.addressbook.entity.Entity.email;

public class ReadContact {
    public static String getFirstname(int location) {
        return first_name.get(location);
    }
    public static String getlastname(int location) {
        return last_name.get(location);
    }
    public static String getAddress(int location) {
        return address.get(location);
    }
    public static String getCity(int location) {
        return city.get(location);
    }
    public static String getState(int location) {
        return state.get(location);
    }
    public static String getZip(int location) {
        return zip.get(location);
    }
    public static String getPhoneNumber(int location) {
        return phone_number.get(location);
    }
    public static String getEmail(int location) {
        return email.get(location);
    }
}
