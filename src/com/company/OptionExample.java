package com.company;

import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Arrays;

/**
 * Created by hovhannes on 4/15/18.
 */
public class OptionExample {


    public static void main(String[] args) {

        Option<String> maybeHaveValue = Option.of("Str");

        Option<String> nullOption = Option.of(null);


        maybeHaveValue.map(s -> s + 100);

        Integer x = null;
        // List<Integer> integers = List.of(Option.of(x), Option.of(15)).flatMap(o -> o);

        List<Integer> integers = List.of(Option.of(x), Option.of(15))
                .filter(o -> o.isDefined())
                .map(o -> o.get());


        System.out.println(integers);


    }

}
