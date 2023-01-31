package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.AdminRegistrationRequest;
import jolaexpress.africa.data.dto.request.CustomerRegistrationRequest;
import jolaexpress.africa.data.dto.response.AdminRegistrationResponse;
import jolaexpress.africa.data.dto.response.CustomerRegistrationResponse;
import jolaexpress.africa.exception.AdminAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;

    private AdminRegistrationRequest adminRequest;

    @BeforeEach
    void setUp() {
        adminRequest = AdminRegistrationRequest
                .builder()
                .firstName("Winnie")
                .lastName("White")
                .email("whitewinnie@email.com")
                .password("password1234")
                .build();
    }
    @Test
    void registerAdmin() throws AdminAlreadyExistException {
        AdminRegistrationResponse response = adminService.register(adminRequest);
        assertThat(response).isNotNull();

    }


    @Test
    void getAllAdmins() {
        assertThat(adminRequest).isNotNull();
        log.info("registered admin email -> {}",adminRequest.getEmail());
    }
    @Test
    void updateProfile() {
        log.info("previous password -> {}", adminRequest.getPassword());
        adminRequest.setPassword("2222");
        assertThat(adminRequest.getPassword()).isEqualTo("2222");
        log.info("password changed -> {}",adminRequest.getPassword());
    }
    @Test
    void deleteAdmin() throws AdminAlreadyExistException {
        adminService.register(adminRequest);
        assertThat(adminRequest).isNotNull();
log.info("saved admin email -> {}", adminRequest.getEmail());

      adminService.deleteAdmin(1L);
assertThat(adminService.getAllAdmin()).isEmpty();
log.info("admin -> {}", adminService.getAllAdmin());

    }
}



