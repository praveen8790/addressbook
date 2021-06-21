package org.bridgelabz.addressbook.services;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.bridgelabz.addressbook.entity.CSVclass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class CSVAndJSONIO extends Operations implements IoServices {
    public static final String filepath = "J:\\hi.csv";

    @Override
    public void writeCSV() throws IOException {

        this.CSVRead();
        Writer writer= Files.newBufferedWriter(Paths.get(filepath));
        writer.write("addressbook,first_name,last_name,address,city,state,zip,phone_number,email\n");
        multiplebook.entrySet().stream().forEach(AddressBookEntry -> {
            AddressBookEntry.getValue().getAddressbooks().forEach(person -> {
                CSVclass csVclass = new CSVclass();
                csVclass.setAddressbookname(AddressBookEntry.getKey());
                csVclass = (CSVclass) person;
                try {
                    writer.write(csVclass.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        writer.close();
    }
    @Override
    public  void CSVRead() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(filepath));
        CsvToBean<CSVclass> csvToBean = new CsvToBeanBuilder<CSVclass>(reader).withType(CSVclass.class)
                                            .withIgnoreLeadingWhiteSpace(true)
                                                    .build();
        Iterator<CSVclass> iterator = csvToBean.iterator();
        while (iterator.hasNext()){
            CSVclass person = iterator.next();
            /*System.out.println(person.getAddressbookname());
            System.out.println(person.getFirst_name());*/
            super.addbooks(person.getAddressbookname(), super.add(person));
        }
        reader.close();
    }
    public void writeJson() throws IOException {
        Gson json = new Gson();
        Writer writer= Files.newBufferedWriter(Paths.get("J:\\hi.json"));
        writer.write(json.toJson(multiplebook));
        writer.close();

    }
    public void readJson() throws IOException {
        Gson json = new GsonBuilder().setLenient().create();
        JsonReader reader1 = json.newJsonReader(new FileReader("J:\\hi.json"));
        reader1.setLenient(true);
        JsonParser jsonp = new JsonParser();
        JsonObject s = (JsonObject) jsonp.parse(reader1);
        s.entrySet().stream().forEach(entry->{
            entry.getValue().getAsJsonObject().get("addressbooks").getAsJsonArray().forEach(element->{
                CSVclass clas =json.fromJson(element,CSVclass.class);
                super.addbooks(entry.getKey(), super.add(clas));
            });
        });
        super.print();
    }

    public static void main(String[] args) throws IOException {
        CSVAndJSONIO operations = new CSVAndJSONIO();

        operations.readJson();


    }
}
