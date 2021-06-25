package org.bridgelabz.addressbook.repository;

import junit.framework.TestCase;
import org.bridgelabz.addressbook.entity.Person;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class DBConnectTest extends TestCase {

    public void testAddMultiplePerson() {
        DBConnect dbConnect = new DBConnect();
        String[] addressbook_name= {"addressbook_1","addressbook_1","addressbook_1"};
        Person[] persons = {new Person()
                ,new Person(),new Person()};
        persons[1].add("ra","ga","sdas","sd","ds","231","2312324","weasdad");
        persons[2].add("gassd","adsa","sdas","sd","ds","231","2312324","weasdad");
        persons[3].add("adsa","safa","sdas","sd","ds","231","2312324","weasdad");
        Assert.assertTrue(dbConnect.addMultiplePerson(Arrays.asList(persons),Arrays.asList(addressbook_name)));
    }
}