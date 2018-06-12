package com.acl.controler;

import com.acl.datamodel.Person;

import java.util.List;

public interface IPersonControler {

    public List<Person> getAgeOver(int age);

    public int getNumberOfPerson();

    public List<String> getCities();

    public List<Person> getPersonByCity(String city);

}
