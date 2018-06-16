package com.company;

import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

import java.util.regex.Pattern;

/**
 * Created by hovhannes on 5/9/18.
 */
public class ValidationExample {
    public static void main(String[] args) {
     //PersonValidator.validatePerson("hovo",25).isInvalid());

       // System.out.print(PersonValidator.validateName("hovo").flatMap((a)->PersonValidator.validateAge(55)).flatMap((a)->PersonValidator.validateAge(10)).isInvalid());

        System.out.println(PersonValidator.validatePerson("hovhannes",20).isInvalid());

    }
}

class PersonValidator {

    private static final Pattern VALID_NAME_CHARS = Pattern.compile("^[a-zA-Z]+$");
    private static final int MIN_AGE = 18;

    public static Validation<Seq<String>, Person> validatePerson(String name, int age) {
        return Validation.combine(validateName(name), validateAge(age)).ap(Person::new);
    }

    public static Validation<String, String> validateName(String name) {
        return VALID_NAME_CHARS.matcher(name).matches()
                ? Validation.valid(name)
                : Validation.invalid("Name contains invalid characters: " + name);
    }

    public static Validation<String, Integer> validateAge(int age) {
        return age < MIN_AGE
                ? Validation.invalid("Age must be at least " + MIN_AGE)
                : Validation.valid(age);
    }

}

 class Person {

    public final String name;
    public final int age;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person(" + name + ", " + age + ")";
    }

}
