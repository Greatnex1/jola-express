package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.exception.CustomerAlreadyExistException;
import jolaexpress.africa.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final ModelMapper mapper = new ModelMapper();
private CustomerRepository customerRepository;
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest request) {
        //ensuring that a user does not register twice with the same email
        var customerExist =  customerRepository.findCustomerByEmail(request.getEmail());
        if(customerExist.isPresent())throw new CustomerAlreadyExistException(String.format("email %s already taken"));
        Customer customer = mapper.map(request,Customer.class);
        //TODO -> password encoder
        Customer savedCustomer = customerRepository.save(customer);
        log.info("registered email -> {}, registered phone-number -> {}",customer.getEmail(),customer.getPhoneNumber());
        return registrationResponse();
    }


    private CustomerRegistrationResponse registrationResponse() {
        return CustomerRegistrationResponse
                .builder()
                .code(201)
                .message("registration successful!")
                .build();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateProfile(Long customerId, String email) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalStateException(String.format("customer with id %d not found")));
   if(email != null && email.length()> 0 && !Objects.equals(customer.getEmail(),email)){
       var customerEmail = customerRepository.findCustomerByEmail(email);
       if(customerEmail.isPresent()){
           throw new CustomerAlreadyExistException("customer with this email" + email + "already exist");
       }
   }

    }

    @Override
    public void deleteCustomer(Long customerId) {
    var exist = customerRepository.existsById(customerId);
    if(!exist){
        throw new IllegalStateException("customer with id" + customerId + "does not exist");
    }else{
        customerRepository.deleteById(customerId);
    }

    }
}
 /*   public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer
                .builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //save customer in db
        customerRepository.save(customer);
    }

    public List <Customer> getCustomer() {
        return customerRepository.findAll();

    }

    public void updateProfile(Long customerId, String email) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("customer with id" + customerId + "not found!"));

        if(email!= null && email.length() > 0 && !Objects.equals(customer.getEmail(),email)){
            var customerByEmail = customerRepository.findCustomerByEmail(email);
            if(customerByEmail.isPresent()){
                throw new CustomerAlreadyExistException("customer/user with this email" + email +  "already exists")
            }
        }
    }*/

