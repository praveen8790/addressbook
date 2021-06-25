package org.bridgelabz.addressbook.repository;


import org.bridgelabz.addressbook.entity.Person;
import org.bridgelabz.addressbook.services.IoServices;
import org.bridgelabz.addressbook.services.Operations;

import java.sql.*;
import java.util.*;

public class DBConnect extends Operations {
    private Connection connection;
    public  DBConnect(){
        String url = "jdbc:mysql://localhost:3306/addressbook_service";
        String user = "root";
        String pass = "praveen123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void addToHashMap(){
        multiplebook = new HashMap<>();
        try {
            ResultSet resultSet=connection.prepareStatement("select * from addressbook_table").executeQuery();
            while (resultSet.next()){
                Person person = new Person();
                person.setFirst_name(resultSet.getString(1));
                person.setLast_name(resultSet.getString(2));
                person.setAddress(resultSet.getString(3));
                person.setCity(resultSet.getString(4));
                person.setState(resultSet.getString(5));
                person.setZip(String.valueOf(resultSet.getLong(6)));
                person.setPhone_number(String.valueOf(resultSet.getLong(7)));
                person.setEmail(resultSet.getString(8));
                String addressbook_name = resultSet.getString(9);
                super.addbooks(addressbook_name, super.add(person));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void  editDBAndLocal(int option,String first_name,String new_value) {
        try {
            ResultSet resultSet=connection.prepareStatement("select * from addressbook_table")
                    .executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            connection.prepareStatement(String.format("update addressbook_table set %s = '%s' where first_name = '%s'",
                    resultSetMetaData.getColumnName(option),new_value,first_name)).execute();
            this.addToHashMap();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void printColumn() throws SQLException {
        ResultSet resultSet=connection.prepareStatement("select * from addressbook_table")
                .executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnTypeName(7));
    }
    public int getPersonByDate(String start,String end) {
        try {
            ResultSet resultSet = connection.prepareStatement(String.format("select  * from addressbook_table where dateAdded between cast('%s' as date ) and cast('%s' as date )",
                    start,end)).executeQuery();
            ArrayList<Person> personArrayList = new ArrayList<>();
            while (resultSet.next()){
                Person person = new Person();
                person.setFirst_name(resultSet.getString(1));
                person.setLast_name(resultSet.getString(2));
                person.setAddress(resultSet.getString(3));
                person.setCity(resultSet.getString(4));
                person.setState(resultSet.getString(5));
                person.setZip(String.valueOf(resultSet.getLong(6)));
                person.setPhone_number(String.valueOf(resultSet.getLong(7)));
                person.setEmail(resultSet.getString(8));
                personArrayList.add(person);
            }
            return personArrayList.size();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void addPersonIntoDB(Person person,String addressbook_name){
        try {
            connection.prepareStatement(String.format("Insert into addressbook_table values (%s,%s,date(now()))",
                    person.toString(),addressbook_name)).execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean addMultiplePerson(List<Person> personList, List<String> addressbook_name){
        Iterator iterator =personList.listIterator();
        Map<Integer, Boolean> AdditionStatus = new HashMap<>();
        while(iterator.hasNext()){
            int i = (int) iterator.next();
            Runnable task = () ->{
                AdditionStatus.put(personList.get(i).hashCode(), false);
                this.addPersonIntoDB(personList.get(i), addressbook_name.get(i));
                AdditionStatus.put(personList.get(i).hashCode(), true);

            };
            Thread thread = new Thread(task);
            thread.start();
        }
        while (AdditionStatus.containsValue(false)) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws SQLException {
        DBConnect dbConnect = new DBConnect();
        dbConnect.printColumn();

    }

}
