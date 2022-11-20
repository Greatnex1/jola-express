package jolaexpress.africa.controller;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("a new customer registration -> {}", customerRequest);
        customerService.register(customerRequest);

    }

    @GetMapping()
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId")Long customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void editCustomerProfile(@PathVariable Long customerId,
                                    @RequestParam(required = false) String email) {
        customerService.updateProfile(customerId, email);


    }


}
