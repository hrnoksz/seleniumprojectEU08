package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){
        //JavaFaker is used to generate RANDOM data
        //Creating faker object to reach methods
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //numerify(#) method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        //598-555-1721 --> every time we run our code, we will get random numbers

        System.out.println("faker.numerify(\"312-###-####\") = " + faker.numerify("312-###-####"));
        //312-846-6055

        String randomNumber = faker.numerify("####-####-####-####");
        System.out.println("randomNumber = " + randomNumber); //1878-4088-1331-1573

        //letterify(?) method is used to generate random letters in the format we want to get
        String randomLetter = faker.letterify("???-????");
        System.out.println("randomLetter = " + randomLetter); //ipr-icsu

        //bothify(###-?#?#) method is used to generate random numbers and letters in the format
        //we want to get
        String randomLetterAndNumber = faker.bothify("#?#?-###-???");
        System.out.println("randomLetterAndNumber = " + randomLetterAndNumber); //8a8z-862-fck

        //System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        //5019-6102-0286-2094

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());


    }
}
