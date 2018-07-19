package hello;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;
    public int age;

    public Customer() {}

    public Customer (String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
