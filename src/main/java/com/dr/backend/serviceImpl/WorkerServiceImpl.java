package com.dr.backend.serviceImpl;


import com.dr.backend.interfaces.WorkerService;
import com.dr.backend.model.Worker;
import com.dr.backend.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.WatchService;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;


    @Override
    public Worker addWorker(Worker worker) {
        if (worker.getIsAvailable() == null) {
            worker.setIsAvailable(true);
        }
        if (worker.getRating() == null) {
            worker.setRating(5.0); // Default New Worker Rating
        }
        return workerRepository.save(worker);


    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Worker not found with ID: " + id));
    }

    @Override
    public List<Worker> filterWorkers(String skill, String district) {
        if (skill != null && district != null) {
            return workerRepository.findBySkillIgnoreCaseAndDistrictIgnoreCase(skill, district);
        }
        if (skill != null) {
            return workerRepository.findBySkillIgnoreCase(skill);
        }
        if (district != null) {
            return workerRepository.findByDistrictIgnoreCase(district);
        }
        return workerRepository.findAll();
    }

    @Override
    public Worker updateWorker(Long id, Worker workerDetails) {
        Worker existingWorker = getWorkerById(id);

        if (workerDetails.getName() != null) existingWorker.setName(workerDetails.getName());
        if (workerDetails.getSkill() != null) existingWorker.setSkill(workerDetails.getSkill());
        if (workerDetails.getExperienceYears() != null) existingWorker.setExperienceYears(workerDetails.getExperienceYears());
        if (workerDetails.getPhoneNumber() != null) existingWorker.setPhoneNumber(workerDetails.getPhoneNumber());
        if (workerDetails.getDistrict() != null) existingWorker.setDistrict(workerDetails.getDistrict());
        if (workerDetails.getCityOrArea() != null) existingWorker.setCityOrArea(workerDetails.getCityOrArea());
        if (workerDetails.getDailyRate() != null) existingWorker.setDailyRate(workerDetails.getDailyRate());
        if (workerDetails.getHourlyRate() != null) existingWorker.setHourlyRate(workerDetails.getHourlyRate());
        if (workerDetails.getProfileImgUrl() != null) existingWorker.setProfileImgUrl(workerDetails.getProfileImgUrl());
        if (workerDetails.getRating() != null) existingWorker.setRating(workerDetails.getRating());
        if (workerDetails.getIsAvailable() != null) existingWorker.setIsAvailable(workerDetails.getIsAvailable());

        return workerRepository.save(existingWorker);
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
