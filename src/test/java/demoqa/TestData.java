package demoqa;

import com.github.javafaker.Faker;

import java.util.Locale;

import static demoqa.utils.RandomUtils.*;

public class TestData {

//    String firstName = "Jakhongir",
//            lastName = "Razzakov",
//            userEmail = "rzzkv@gmail.com",
//            currentAddress = "currentAddress",
//            userNumber = "8936236723",
//            subject = "Maths",
//            hobbies = "Sports",
//            picture = "test.jpg";

    String firstName = randomString(10),
            lastName = randomString(10),
            userEmail = randomEmail(),
            currentAddress = randomString(10),
            userNumber = randomNumber(),
            hobbies = randomHobbies(),
            subject = randomSubject(),
            picture = "test.jpg";


//    Faker faker = new Faker(new Locale("en-SG"));
//    String firstName = faker.name().firstName(),
//            lastName = faker.name().lastName(),
//            userEmail = faker.internet().emailAddress(),
//            currentAddress = faker.address().streetAddress(),
//            userNumber = faker.phoneNumber().cellPhone(),
//            hobbies = randomHobbies(), //can`n use faker here
//            subject = randomSubject(),
//            picture = faker.internet().image(); //todo modify uploadPicture method

}
