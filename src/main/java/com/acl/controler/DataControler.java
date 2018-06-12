package com.acl.controler;

import com.acl.datamodel.Person;
import com.acl.reader.IReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class DataControler implements IPersonControler {

    @Inject
    IReader<Person> reader;

    List<Person> listOfPeron;

    public DataControler() {

    }

    @PostConstruct
    public void init() {
        listOfPeron = reader.read();
    }

    @Override
    public List<Person> getAgeOver(int age) {
        Predicate<Person> ageOver = p -> p.getAge() > age;
        return listOfPeron.stream().filter(ageOver).collect(Collectors.toList());
    }

    @Override
    public int getNumberOfPerson() {
        return listOfPeron.size();
    }

    @Override
    public List<String> getCities() {
        return null;
    }

    @Override
    public List<Person> getPersonByCity(String city) {
        return null;
    }
}
