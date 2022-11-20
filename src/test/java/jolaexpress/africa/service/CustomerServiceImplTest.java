package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class CustomerServiceImplTest {
   @Autowired
   private  CustomerService customerService;

   private CustomerRegistrationRequest request;

    @BeforeEach
    void setUp() {
      request = CustomerRegistrationRequest
              .builder()
              .email("wiz@email.com")
              .firstName("wiz")
              .lastName("snow")
              .phoneNumber("08174697745")
              .password("2222")
              .build();
    }


    @Test
    void registerCustomer() {
       CustomerRegistrationResponse response = customerService.register(request);
      assertThat(response).isNotNull();
       assertThat(response.getMessage()).isNotNull();
     //  assertThat(response.getId()).isGreaterThan(0);
    }

    @Test
    void getCustomer() {
        assertThat(request).isNotNull();
        log.info(" registered customer email -> {}",request.getEmail());
        assertEquals("wiz@email.com",request.getEmail());

;    }

    @Test
    void updateProfile() {
    }

    @Test
    void customerRepository() {
    }
    @Test
    void deleteCustomer(){

    }

}