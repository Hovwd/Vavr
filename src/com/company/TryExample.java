package com.company;

import io.vavr.Lazy;
import io.vavr.control.Option;
import io.vavr.control.Try;


import java.net.URI;


import static io.vavr.API.unchecked;

/**
 * Created by hovhannes on 4/24/18.
 */
public class TryExample {

    public static void main(String[] args)  {
        Try<Integer> result=  divide(50,0);

        System.out.println("is Failure " + result.isFailure());
        result.recoverWith(ArithmeticException.class,divide(51,3));

        result.onFailure((s)->System.out.println(s.getMessage()));

        result.onSuccess(System.out::println);

      //  Option.of("").map(s->new URI(s));

        Option.of("").map(unchecked(s->new URI(s)));


        //Lazy

        Lazy<Double> lazy = Lazy.of(Math::random);
        lazy.isEvaluated(); // = false
        lazy.get();         // = 0.123 (random generated)
        lazy.isEvaluated(); // = true
        lazy.get();         // = 0.123 (memoized)

    }


    static Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }
}
