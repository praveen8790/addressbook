package org.bridgelabz.addressbook.repository;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.bridgelabz.addressbook.entity.CSVClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestRestAssured {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }
    public CSVClass[] getEmployeeList(){
        Response response = RestAssured.get( "/persons");
        CSVClass[] arrayOfPersons = new Gson().fromJson(response.asString(), CSVClass[].class);
        Arrays.asList(arrayOfPersons).forEach(csVclass -> System.out.println(csVclass.toString()));
        return arrayOfPersons;
    }
    public Response addEmployeeToJsonServer(CSVClass person) {
        String personJson = new Gson().toJson(person);
        RequestSpecification request = RestAssured.given();
        request.contentType("application/json");
        request.body(personJson);
        return request.post( "/persons");
    }
    @Test
    public void givenPersonDataInJSONServer_WhenRetrieved_ShouldMatchTheCount()
    {
        Assert.assertEquals(4,getEmployeeList().length);
    }

    @Test
    public void givenNewPersonWhenAddedShouldReturn201ResponseCode() {
        CSVClass person = new CSVClass();
        person.add("ravi","choudhary","ank","gadhwal","AP","3424234",
                "8790324234","ravi@gmail.com");
        person.setAddressbookname("addr_1");
        Response response = addEmployeeToJsonServer(person);
        int status = response.getStatusCode();
        Assert.assertEquals(201,status);
    }

    @Test
    public void givenListOfNewPersonsWhenAddedShouldReturn() {
        CSVClass[] persons = {new CSVClass(),new CSVClass(),new CSVClass()};
        persons[0].add("kasi","choudhary","ank","gadhwal","AP","3424234",
                "8790324234","kasi@gmail.com");
        persons[1].add("vishu","choudhary","ank","gadhwal","AP","3424234",
                "8790324234","vishu@gmail.com");
        persons[2].add("pappu","choudhary","ank","gadhwal","AP","3424234",
                "8790324234","pappu@gmail.com");
        persons[0].setAddressbookname("addr_1");
        persons[1].setAddressbookname("addr_2");
        persons[2].setAddressbookname("addr_1");
        for (CSVClass person : persons) {
            int status = addEmployeeToJsonServer(person).getStatusCode();
            Assert.assertEquals(201,status);
        }
    }

    @Test
    public void givenNewValuesForPerson_WhenUpdated_ShouldMatch200Response() {
        CSVClass person = new CSVClass();
        person.add("kasi", "choudhary", "ank", "gadhwal", "AP", "3424234",
                "123456789", "kasi@gmail.com");
        person.setAddressbookname("addr_2");
        String personJson = new Gson().toJson(person);
        RequestSpecification request = RestAssured.given();
        request.contentType("application/json");
        request.body(personJson);
        int status= request.put("/persons/"+person.getFirst_name()).getStatusCode();
        Assert.assertEquals(200,status);

    }

    @Test
    public void givenPersonToDelete_WhenDeletedShouldMatch200Response() {
        String first_name = "ravi";
        RequestSpecification request = RestAssured.given();
        request.contentType("application/json");
        Response response = request.delete("/persons/"+first_name);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200,statusCode);
    }
}
