package org.bridgelabz.addressbook.entity;

import com.opencsv.bean.CsvBindByName;

import java.util.Iterator;

public class CSVClass extends Person {
    @CsvBindByName(column = "addressbook")
    public String addressbookname;

    public String getAddressbookname() {
        return addressbookname;
    }

    public void setAddressbookname(String addressbookname) {
        this.addressbookname = addressbookname;
    }

    @Override
    public String toString() {
        return
                addressbookname + ',' +
                        first_name + ',' +
                        last_name + ',' +
                        address + ',' +
                        city + ',' +
                        state + ',' +
                        zip + ',' +
                        phone_number + ',' +
                        email + '\n';
    }
}
