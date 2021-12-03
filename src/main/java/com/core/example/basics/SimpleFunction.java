package com.core.example.basics;

import java.util.function.Function;

public class SimpleFunction {

    public static void main(String[] args) {

        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("simple text");   // 6

        System.out.println(apply);

    }

}
