package com.cydeo.test.day14_java_faker_driver_utility_singleton;

public class SingleTon {

    // 1- create private constructor
    private SingleTon(){}

    // 2- create private static String
    // prevent access and provide a getter method
    private static String word;

    // this utility method will return the "word" in the way we want to return
    public static String getWord(){

       if (word == null) {
           System.out.println("First time call. Work object is null. " + "Assign value to it now!");
           word = "something";
       } else {
           System.out.println("Word already has value.");
       }
        return word;
    }


}
