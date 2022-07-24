package com.cydeo.test.day14_java_faker_driver_utility_singleton;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){

        // creating Faker object to reach methods
        Faker faker = new Faker();

        // Faker faker = new Faker((new Locale("fr"))); // we can choose different language with this

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        // numerify() method will generate random numbers in the format we want to get
        String randomNumber = faker.numerify("###-###-####");
        System.out.println(randomNumber);
        System.out.println("faker.numerify(\"647-###-####\") = " + faker.numerify("647-###-####"));

        //letterify() method will return random letters where we pass '?'
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));

        //bothify() method can return mix of letters and numbers
        System.out.println("faker.bothify(\"?#? #?#\") = " + faker.bothify("?#? #?#").toUpperCase());

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replace("-", ""));

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Tyler"));

    }
}
