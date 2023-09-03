package demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class RandomUtils {
    static Random generator = new Random();
    public static String randomString(int length) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String randomEmail() {
        return randomString(10) + "@gmail.com";
    }
    public static String randomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = randomInt(0, hobbies.length - 1);

        return hobbies[index];
    }
    public static String randomSubject() {
        String[] subject = {"Maths", "English", "Arts", "Computer Science", "Chemistry", "History", "Civics"};
        int index = randomInt(0, subject.length - 1);

        return subject[index];
    }

    public static String randomNumber() {
        int num1, num2, num3;
        int set1, set2;

        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin
        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);

        set1 = generator.nextInt(643) + 100;
        set2 = generator.nextInt(8999) + 1000;

//        int number = num1 + num2 + num3 + set1 + set2; output is 5432, don`t know why
        String number = num1 + "" + num2 + "" + num3 + "" + set1 + "" + set2;

        return number;
    }



}
