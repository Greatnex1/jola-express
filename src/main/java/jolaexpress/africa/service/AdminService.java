package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.AdminRegistrationRequest;
import jolaexpress.africa.data.dto.response.AdminRegistrationResponse;
import jolaexpress.africa.data.model.Admin;
import jolaexpress.africa.exception.AdminAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    AdminRegistrationResponse register (AdminRegistrationRequest adminRequest) throws AdminAlreadyExistException;

    List<Admin> getAllAdmin();

    void updateProfile(Long adminId, String email, String password);

    String deleteAdmin(Long id);




}
