package jolaexpress.africa.repository;

import jolaexpress.africa.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    Optional <Customer> findCustomerByEmail (String email);

  //  Optional<Customer> findByResetToken(String resetToken);
}
