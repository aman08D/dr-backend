package com.dr.backend.interfaces;

import com.dr.backend.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    List<Doctor> filterDoctors(String specialization, String district);
    void deleteDoctor(Long id);
}
