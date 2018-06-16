package com.company;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.control.Option;

import java.util.function.Function;

/**
 * Created by hovhannes on 4/15/18.
 */
public class FunctionExample {

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;

        Function1<Integer,Integer> abs =Math::abs;
        System.out.println(sum.apply(-45,20));

        Function0<Double> randomNumber =Function0.of(Math::random);



        //Composition

//       f : X → Y
//
//        g : Y → Z
//
//          h: g(f(x)) => X → Z.


        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(5));



      //  Lifting
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;

        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

        Option<Integer> i1 = safeDivide.apply(1, 0);



        Option<Integer> i2 = safeDivide.apply(4, 2);


        //Partial application

        // f:(X,Y,Z) -> N
        //partial f:(Y,Z)->N

        Function2<Integer, Integer, Integer> sum2 = (a, b) -> a + b;
        Function1<Integer,Function1<Integer,Integer>> curredFunction = sum2.curried();

        System.out.println(curredFunction.apply(26).apply(26));



        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();

        System.out.print(randomValue1 ==randomValue2);





    }
}
