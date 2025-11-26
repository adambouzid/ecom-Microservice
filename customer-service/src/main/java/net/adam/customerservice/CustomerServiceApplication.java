package net.adam.customerservice;

import net.adam.customerservice.entities.Customer;
import net.adam.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .email("adam@gmail.com").nom("adam")
                    .build());
            customerRepository.save(Customer.builder()
                    .email("badr@gmail.com").nom("badr")
                    .build());
            customerRepository.save(Customer.builder()
                    .email("nabil@gmail.com").nom("nabil")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("==================");
                System.out.println(c.getId());
                System.out.println(c.getEmail());
                System.out.println(c.getNom());
                System.out.println("==================");
            });
        };
    }
}
