package de.arnav.schoolmanagement.web;

import de.arnav.schoolmanagement.model.Staff;
import de.arnav.schoolmanagement.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @GetMapping("/staff")
    public ResponseEntity<Iterable<Staff>> getStaff(){
        return ResponseEntity.ok(staffService.getStaff());
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id){
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PutMapping("/staff/{id}")
    public ResponseEntity<Staff> updateStaff(Long id, Staff updatedstaff){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(staffService.updateStaff(id, updatedstaff));
    }

    @PostMapping("/staff/add")
    public ResponseEntity<Staff> createStaff(@RequestBody @Valid Staff staff){
        return ResponseEntity.status(HttpStatus.CREATED).body(staffService.createStaff(staff));
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id){
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Staff with id " + id + " deleted");
    }
}
