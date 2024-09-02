package de.arnav.schoolmanagement.service;

import de.arnav.schoolmanagement.model.Role;
import de.arnav.schoolmanagement.model.Staff;
import de.arnav.schoolmanagement.repository.RoleRepository;
import de.arnav.schoolmanagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final RoleRepository roleRepository;

    public StaffService (StaffRepository staffRepository, RoleRepository roleRepository) {
        this.staffRepository = staffRepository;
        this.roleRepository = roleRepository;
    }

    public Iterable<Staff> getStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff with id" + id + "not found"));
    }

    public Staff updateStaff(Long id, Staff updatedstaff) {
        Staff existingStaff = getStaffById(id);

        existingStaff.setName(updatedstaff.getName());
        existingStaff.setAddress(updatedstaff.getAddress());
        existingStaff.setEmail(updatedstaff.getEmail());
        return staffRepository.save(existingStaff);
    }

    public Staff createStaff(Staff staff) {
        Role staffRole = roleRepository.getByName("STAFF");
        staff.setRole(roleRepository.getByName("STAFF"));
        return staffRepository.save(staff);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
