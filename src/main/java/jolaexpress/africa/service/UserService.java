package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.LoginRequest;
import jolaexpress.africa.data.dto.response.LoginResponse;
import jolaexpress.africa.data.model.Customer;
import jolaexpress.africa.data.model.JolaExpressUser;
import jolaexpress.africa.exception.UserNotFoundException;

import java.util.Optional;

public interface UserService {
    JolaExpressUser getUserByEmail(String email) throws UserNotFoundException;

    Optional<Customer> findCustomerByEmail(String email);

//    Optional<Customer> findByResetToken(String resetToken);

    LoginResponse login(LoginRequest loginRequest);

    void save(Customer userEmail);
}
