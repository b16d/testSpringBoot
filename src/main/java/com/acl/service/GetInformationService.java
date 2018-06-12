package com.acl.service;

import com.acl.controler.IPersonControler;
import com.acl.datamodel.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@RestController
public class GetInformationService {

    @Inject
    IPersonControler personControler;

    @RequestMapping("/")
    public String index() {
        return "Welcom mu mini service";
    }

    @RequestMapping("/getAverageAge")
    public String getAverageAge() {

        double averageAge  = personControler.getAgeOver(0)
                .stream().mapToDouble(Person::getAge).average().getAsDouble();
        return "" + averageAge;
    }

    @RequestMapping("/getNumberOfPersonWithAgeOver")
    public String getAverageAge(@RequestParam(value="age", defaultValue="0")int age) {

        double numberOfPerson  = personControler.getAgeOver(age).size();

        return "" + numberOfPerson;
    }

    @RequestMapping("/getPersonWithAgeOver")
    public List<Person> getPersonWithAgeOver(@RequestParam(value="age", defaultValue="0")int age) {

        return personControler.getAgeOver(age);
    }
}