package com.company;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * Created by hovhannes on 4/15/18.
 */
public class TupleExample {
    public static void main(String[] args) {
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);

        String value1 = java8._1; //Java
        Integer value12 = java8._2;//8


        Tuple2<Integer, Integer> that = java8.map(
                s -> 2,
                i -> i / 8
        );

        Tuple2<String, Integer> that1 = java8.map(
                (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
        );

        String that2 = java8.apply(
                (s, i) -> s.substring(2) + "vr " + i / 8
        );
    }
}
