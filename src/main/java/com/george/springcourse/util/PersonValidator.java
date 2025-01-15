package com.george.springcourse.util;

import com.george.springcourse.dao.PersonDAO;
import com.george.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDao;

    @Autowired
    public PersonValidator(PersonDAO personDao) {
        this.personDao = personDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //проверить уникальность ФИО в бд
        if(personDao.getPersonByFullName(person.getFullName()).isPresent()){
           errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
        }

    }
}
