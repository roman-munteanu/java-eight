package com.munteanu.functional_interfaces;

import com.munteanu.model.Person;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class MainFunctionalInterfaces {
    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        System.out.println(converter.convert("123"));

        Converter<String, String> conv = Something::startsWith;
        System.out.println(conv.convert("Java"));

        PersonFactory<Person> personFactory = Person::new;
        Person thomas = personFactory.create("Thomas", "Mohme");
        System.out.println(thomas);

        final int num = 1;
        Converter<Integer, String> addAndConvert = (from) -> String.valueOf(from + num);
        System.out.println(addAndConvert.convert(2));
    }
}