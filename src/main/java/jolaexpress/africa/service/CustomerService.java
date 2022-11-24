package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import jolaexpress.africa.data.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    CustomerRegistrationResponse register(CustomerRegistrationRequest request);

    List   <Customer> getAllCustomers ();

    void updateProfile(Long customerId,String email );

    void deleteCustomer(Long customerId);
}