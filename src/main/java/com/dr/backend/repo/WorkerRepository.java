package com.dr.backend.repo;

import com.dr.backend.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkerRepository  extends JpaRepository<Worker,Long> {

    List<Worker> findBySkillIgnoreCase(String skill);

    // 2. Filter by District (e.g. Patna)
    List<Worker> findByDistrictIgnoreCase(String district);

    // 3. Filter by Skill + District (e.g. ELECTRICIAN in Patna)
    List<Worker> findBySkillIgnoreCaseAndDistrictIgnoreCase(String skill, String district);


}

