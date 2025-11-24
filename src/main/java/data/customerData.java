package data;

import Utils.FakerData;
import models.Customer;

public class customerData {


    public static Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setName(String.valueOf(FakerData.faker.name().fullName()));
        customer.setEmail(FakerData.faker.internet().emailAddress());
        customer.setPhone(FakerData.faker.phoneNumber().cellPhone());
        customer.setAddress(FakerData.faker.address().fullAddress());
        return customer;
    }
}
