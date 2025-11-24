package Utils;


import com.github.javafaker.Faker;
import models.Customer;

public class FakerData {
    public static Faker faker = new Faker();

    public static Customer generateRandomCustomer() {
        return new Customer(
                faker.name().fullName(),
                faker.internet().emailAddress(),
                faker.numerify("0#########"),
                faker.address().streetAddress()
        );
    }
}
