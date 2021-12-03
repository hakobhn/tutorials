package com.core.example.basics;

import java.util.function.Function;

public class ChainFunction {

    public static void main(String[] args) {

        Function<String, Integer> func = x -> x.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func.andThen(func2).apply("simple text");   // 12

        System.out.println(result);

    }


}
