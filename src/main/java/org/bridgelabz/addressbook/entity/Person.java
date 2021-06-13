package org.bridgelabz.addressbook.entity;

import com.opencsv.bean.CsvBindByName;

public class Person {
    @CsvBindByName(column = "first_name")
    public String first_name;
    @CsvBindByName(column = "last_name")
    public String last_name;
    @CsvBindByName(column = "address")
    public String address;
    @CsvBindByName(column = "city")
    public String city;
    @CsvBindByName(column = "state")
    public String state;
    @CsvBindByName(column = "zip")
    public String zip;
    @CsvBindByName(column = "phone_number")
    public String phone_number;
    @CsvBindByName(column = "email")
    public String email;

    @Override
    public String toString() {
        return  "first_name=" + first_name + '/' +
                "last_name=" + last_name + '/' +
                "address=" + address + '/' +
                "city=" + city + '/' +
                "state=" + state + '/' +
                "zip=" + zip + '/' +
                "phone_number=" + phone_number + '/' +
                "email=" + email + '/' +
                '\n';
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
