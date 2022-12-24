package jolaexpress.africa.repository;

import jolaexpress.africa.data.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

    Optional <Vendor> findVendorByEmail(String email);
}
