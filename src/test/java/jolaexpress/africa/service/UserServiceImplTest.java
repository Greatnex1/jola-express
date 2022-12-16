package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.LoginRequest;
import jolaexpress.africa.data.model.Admin;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.data.model.JolaExpressUser;
import jolaexpress.africa.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserServiceImplTest {
@Autowired
    private UserService userService;

@Autowired
private CustomerRepository customerRepository;

private LoginRequest userLogin;

private Customer customer;



@BeforeEach
void up(){

     customer = Customer.builder().build();
    customer.setFirstName("James");
    customer.setLastName("West");
    customer.setEmail("james@email.com");
    customer.setPassword("2222");

    customerRepository.save(customer);

    userLogin = LoginRequest.builder()
            .email("james@email.com")
            .password("2222")
            .build();
}
    @Test
    void login() {
       var response = userService.login(userLogin);
        assertThat(response).isNotNull();

        log.info("Welcome -> {} you are logged in as a customer", customer.getEmail());
assertThat(response.getCode()).isEqualTo(200);
    }

    @Test
    void getUserByEmail() {
    //assertThat(userService).isNotNull();
        assertThat(customer.getEmail()).isEqualTo("james@email.com");
   // assertEquals("jamey@email.com",customer.getEmail());
       // System.out.println(user.getEmail());
    //log.info("user saved in db :: ", user.getEmail());

    }
}