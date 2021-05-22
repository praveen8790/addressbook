package org.bridgelabz.addressbook.service;

import static org.bridgelabz.addressbook.Main.scanner;
import static org.bridgelabz.addressbook.entity.Entity.first_name;
import static org.bridgelabz.addressbook.entity.Entity.last_name;

public class SearchName {
    public int searchable(){
        System.out.println("enter the full name of contact");
        int location=0;
        String firstname = scanner.next();
        for(int i=0;i<first_name.size();i++){
            if(firstname.equals(ReadContact.getFirstname(i))){
                location = i;
                break;
            }
        }
        return location;
    }
}
