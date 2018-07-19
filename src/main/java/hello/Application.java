package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Customer("Alice", "AAA", 22));
        repository.save(new Customer("Bob", "AAA", 11));

        for (Customer customer : repository.findAll()) {
            System.out.println("\n" + customer);
        }


        System.out.println(repository.findByFirstName("\n" + "Alice"));

        for (Customer customer : repository.findByLastName("AAA")) {
            System.out.println(customer);
        }

        System.out.println("\n");

        for(Customer customer : repository.findByAgeAndLastName(11, "AAA")) {
            System.out.println(customer);
        }
    }
}
