package com.dr.backend.serviceImpl;


import com.dr.backend.interfaces.DoctorService;
import com.dr.backend.model.Doctor;
import com.dr.backend.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor addDoctor(Doctor doctor) {
        if (doctor.getIsAvailable() == null) {
            doctor.setIsAvailable(true);
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        if(doctor.getId()==null){
            throw new IllegalArgumentException("Product ID is required for update operation");
        }

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {

        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    @Override
    public List<Doctor> filterDoctors(String specialization, String district) {
        if(specialization != null && district !=null ){
            return doctorRepository.findBySpecializationIgnoreCaseAndDistrictIgnoreCase(specialization ,district);
        }
        if (specialization != null) {
            return doctorRepository.findBySpecializationIgnoreCase(specialization);
        }
        if (district != null) {
            return doctorRepository.findByDistrictIgnoreCase(district);
        }
        return doctorRepository.findAll();
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    }

