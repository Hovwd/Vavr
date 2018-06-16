package com.company;

import io.vavr.control.Either;

import java.util.Collections;
import java.util.function.Supplier;

/**
 * Created by hovhannes on 5/9/18.
 */
public class EitherExamples {
    public static void main(String[] args) {
     computeWithEither(45).isLeft();


    }

    private static Either<String, Integer> computeWithEither(int marks) {
        if (marks < 85) {
            return Either.left("Marks not acceptable");
        } else {
            return Either.right(marks);
        }
    }
}
