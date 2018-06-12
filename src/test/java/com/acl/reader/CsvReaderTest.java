package com.acl.reader;

import com.acl.datamodel.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CsvReaderTest {

    public CsvReader csvReader;

    @Before
    public void init() {
     }

    @Test
    public void testReadWithData() {
        csvReader = new CsvReader("C:\\Users\\alban\\IdeaProjects\\server\\src\\main\\resources\\data\\person.csv");

        List<Person> personList = csvReader.read();

        Assert.assertEquals(11, personList.size());
    }

    @Test
    public void testReadWithNoFile() {
        csvReader = new CsvReader("C:\\Users\\alban\\IdeaProjects\\server\\src\\main\\resources\\data\\test.csv");

        List<Person> personList = csvReader.read();

        Assert.assertEquals(0, personList.size());
    }
}
