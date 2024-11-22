package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Staff;
import com.example.demo.repository.StaffRepository;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable String id) {
        return staffRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff newStaff) {
        return staffRepository.save(newStaff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable String id, @RequestBody Staff updatedStaff) {
        return staffRepository.findById(id).map(existing -> {
            existing.setStaffId(updatedStaff.getStaffId());
            existing.setDepartmentId(updatedStaff.getDepartmentId());
            existing.setPhone(updatedStaff.getPhone());
            return staffRepository.save(updatedStaff);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable String id) {
        staffRepository.deleteById(id);
        return "Staff with ID " + id + " deleted.";
    }
}
