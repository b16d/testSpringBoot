package com.acl.configuration;

import com.acl.datamodel.Person;
import com.acl.reader.CsvReader;
import com.acl.reader.IReader;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IReader<Person> getReader() {
        return new CsvReader("C:\\Users\\alban\\IdeaProjects\\server\\src\\main\\resources\\data\\person.csv");
    }
}
