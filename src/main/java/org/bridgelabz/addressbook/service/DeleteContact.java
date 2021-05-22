package org.bridgelabz.addressbook.service;

import static org.bridgelabz.addressbook.entity.Entity.*;

public class DeleteContact {
    public void delete(int location){
        first_name.remove(location);
        last_name.remove(location);
        address.remove(location);
        city.remove(location);
        state.remove(location);
        zip.remove(location);
        phone_number.remove(location);
        email.remove(location);
    }

}
