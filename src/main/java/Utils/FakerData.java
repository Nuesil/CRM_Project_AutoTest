package Utils;


import com.github.javafaker.Faker;

public class FakerData {
    public static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }
}
