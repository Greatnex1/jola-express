package jolaexpress.africa.controller;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.exception.CustomerAlreadyExistException;
import jolaexpress.africa.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/customer/register")
public record CustomerController(CustomerServiceImpl customerService) {
@PostMapping()
    public void registerCustomer( @RequestBody CustomerRegistrationRequest customerRequest){
        log.info("a new customer registration -> {}", customerRequest);
        customerService.register(customerRequest);

    }
  @GetMapping()
    public  List <Customer> getCustomers(){
    return customerService.getAllCustomers();
  }
  @PutMapping(path = "{customerId}")
    public void editCustomerProfile(@PathVariable Long customerId,
                                    @RequestParam(required = false)String email){
    customerService.updateProfile(customerId,email);




  }

}
