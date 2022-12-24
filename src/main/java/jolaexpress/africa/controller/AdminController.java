package jolaexpress.africa.controller;

import jolaexpress.africa.data.dto.request.AdminRegistrationRequest;
import jolaexpress.africa.exception.AdminAlreadyExistException;
import jolaexpress.africa.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path="api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin (@Valid @RequestBody AdminRegistrationRequest adminRequest) throws AdminAlreadyExistException {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.register(adminRequest));
    }
@GetMapping("/all_admin")
    public ResponseEntity<?>getAllAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmin());
}
@DeleteMapping(path = "{adminId}")
    public void deleteAdmin(@PathVariable ("adminId")Long adminId){
        log.info("Admin records deleted");
        adminService.deleteAdmin(adminId);

}





}
