package com.munteanu.functional_interfaces;

import com.munteanu.model.Person;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class MainBuiltInFunctionalInterfaces {
    public static void main(String[] args) {

        // Predicates
        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean pRes = predicate.test("foo");
        boolean pNegRes = predicate.negate().test("foo");
        System.out.println(pRes + " " + pNegRes);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        System.out.println(isNull.test(null));

//        Predicate<Boolean> isEmpty = String::isEmpty;
//        Predicate<Boolean> isNotEmpty = isEmpty.negate();

        // Functions
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String btsRes = backToString.apply("123");

        // Suppliers
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get();

        // Consumers
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFullName() + "!");
        greeter.accept(new Person("John", "Doe"));
    }
}
