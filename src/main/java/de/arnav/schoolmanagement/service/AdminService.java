package de.arnav.schoolmanagement.service;

import de.arnav.schoolmanagement.model.Admin;
import de.arnav.schoolmanagement.model.Role;
import de.arnav.schoolmanagement.repository.AdminRepository;
import de.arnav.schoolmanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    public AdminService(AdminRepository adminRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
    }

    public Iterable<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin with id" + id + "not found"));
    }

    public Admin updateAdmin(Long id, Admin updatedadmin) {
        Admin existingAdmin = getAdminById(id);
        existingAdmin.setName(updatedadmin.getName());
        existingAdmin.setEmail(updatedadmin.getEmail());
        return adminRepository.save(existingAdmin);
    }

    public Admin createAdmin(Admin admin) {
        Role adminRole = roleRepository.getByName("ADMIN");
        admin.setRole(roleRepository.getByName("ADMIN"));
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
