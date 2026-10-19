package com.dr.backend.repo;
import com.dr.backend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface DoctorRepository  extends  JpaRepository<Doctor ,Long>{

    // 1. Search by Specialization (e.g. Find all Dentists)
    List<Doctor> findBySpecializationIgnoreCase(String specialization);

    // 2. Search by District (e.g. Find all Doctors in Patna)
    List<Doctor> findByDistrictIgnoreCase(String district);

    // 3. Combined Filter: Specialization + District (e.g. Dentists in Patna)
    List<Doctor> findBySpecializationIgnoreCaseAndDistrictIgnoreCase(String specialization, String district);
}
