package de.arnav.schoolmanagement.web;

import de.arnav.schoolmanagement.model.Admin;
import de.arnav.schoolmanagement.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public ResponseEntity<Iterable<Admin>> getAdmins(){
        return ResponseEntity.ok(adminService.getAdmins());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(Long id, Admin updatedadmin){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(adminService.updateAdmin(id, updatedadmin));
    }

    @PostMapping("/admin/add")
    public ResponseEntity<Admin> createAdmin(Admin admin){
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.createAdmin(admin));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Admin with id " + id + " deleted");
    }
}
