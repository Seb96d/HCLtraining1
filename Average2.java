package com.company;

import java.util.function.Function;
import java.util.stream.Stream;

public class Average2 {
    public static void main (String[] args) {
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        int[] a = new int[] {1,3,5};

        Stream stream = Stream.of(a);

        stream.forEach(
                o -> {
                    System.out.println(o);
                }
        );

//        Function <Double, Function <Double, Double> volume = h -> r -> 3.14*r*r*h;

        Function< Integer, Integer> square = y -> y^2;

        Function <Double, Function <Double, Double>> sumof = r -> h -> (Math.PI * r * r * h)/3;

        System.out.println("Cone V : " +sumof.apply(5.5).apply(15.3));


        Function <Double, Function <Double, Function<Double, Double>>> sumof2 = x -> y -> z -> x + y +z;


        System.out.println(sumof2.apply(20.0).apply(30.0).apply(2.0));






    }


}
