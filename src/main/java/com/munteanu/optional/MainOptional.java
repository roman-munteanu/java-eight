package com.munteanu.optional;

import java.util.Optional;

/**
 * Created by romunteanu on 1/12/2016.
 */
public class MainOptional {
    public static void main(String[] args) {

        Optional<String> maybeString = Optional.of("Foo");

        System.out.println(maybeString.isPresent());
        System.out.println(maybeString.get());
        System.out.println(maybeString.orElse("Bar"));
        System.out.println(Optional.ofNullable(null).orElse("Bar"));

        maybeString.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
