package com.company;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;

/**
 * Created by hovhannes on 5/9/18.
 */
public class CaseExample {
    public static void main(String[] args) {
        String arg = "-v";

        Object r = Match(arg).of(
                Case($(isIn("-h", "--help")), o -> run(CaseExample::displayHelp)),
                Case($(isIn("-v", "--version")), o -> run(CaseExample::displayVersion)),
                Case($("-u"),"other"),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );


        System.out.println("match: " + r);
    }

    private static void displayHelp() {System.out.println("This is a help message.");}
    private static void displayVersion() {System.out.println("This is a version message.");}
}
