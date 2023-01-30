package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.exception.CustomerAlreadyExistException;

import java.util.List;

public interface CustomerService {

    CustomerRegistrationResponse register(CustomerRegistrationRequest request) throws CustomerAlreadyExistException;

    List   <Customer> getAllCustomers ();

    void updateProfile(Long customerId,String email ) throws CustomerAlreadyExistException;

    void deleteCustomer(Long customerId);
}