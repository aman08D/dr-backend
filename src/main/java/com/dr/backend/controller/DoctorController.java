package com.dr.backend.controller;

import com.dr.backend.interfaces.DoctorService;
import com.dr.backend.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // 1. Add Doctor (POST)
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor saved = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);}

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestParam Long id,@RequestBody Doctor doctor){
        doctor.setId(id);
        doctorService.updateDoctor(doctor);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 2. Get All Doctors (GET)
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // 3. Get Doctor by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // 4. Filter Doctors by Specialization and/or District (GET)
    // Example: /api/doctors/filter?specialization=DENTIST&district=Patna
    @GetMapping("/filter")
    public ResponseEntity<List<Doctor>> filterDoctors(
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) String district
    ) {
        return ResponseEntity.ok(doctorService.filterDoctors(specialization, district));
    }

    // 5. Delete Doctor (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully with ID: " + id);
    }
}
