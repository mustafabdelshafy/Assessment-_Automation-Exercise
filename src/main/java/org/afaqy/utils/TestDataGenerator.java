package org.afaqy.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

    public static String generateFullName() {
        return faker.name().fullName();
    }

    public static String generateEmail() {
        return "auto_" + System.currentTimeMillis() + "@testmail.com";
    }

    public static String generatePassword() {
        return faker.internet().password(8, 12);
    }

    public static String generatePhoneNumber() {
        return "010" + faker.number().digits(8);
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateCompany() {
        return faker.company().name();
    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

    public static String generateState() {
        return faker.address().state();
    }

    public static String generateCity() {
        return faker.address().city();
    }

    public static String generateZipCode() {
        return faker.address().zipCode();
    }

    public static String generateDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String generateMonth() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        int index = faker.number().numberBetween(0, 12); // 0 to 11
        return months[index];
    }


    public static String generateYear() {
        return String.valueOf(faker.number().numberBetween(1980, 2005));
    }
}
