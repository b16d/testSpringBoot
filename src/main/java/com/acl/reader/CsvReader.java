package com.acl.reader;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.util.Strings;

import com.acl.datamodel.Person;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements IReader<Person> {

    private String filePath = Strings.EMPTY;

    public CsvReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Person> read() {
        return read(filePath);
    }

    private List<Person> read(String filePath) {

        List<Person> personArrayList = new ArrayList<>();

        try {
            Reader fileToRead = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(fileToRead);

            for (CSVRecord record :records) {
                personArrayList.add(new Person(record.get(Headers.Nom),
                        record.get(Headers.Prenom),
                        Integer.parseInt(record.get(Headers.Age)),
                        record.get(Headers.Ville)));

            }

        } catch (IOException e) {
            System.out.println(e);
        }

        return personArrayList;
    }

    public enum Headers {
        Nom, Prenom, Age, Ville;
    }
}
