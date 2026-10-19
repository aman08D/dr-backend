package com.dr.backend.interfaces;

import com.dr.backend.model.Worker;
import java.util.List;

public interface WorkerService {

    Worker addWorker(Worker worker);
    List<Worker> getAllWorkers();
    Worker getWorkerById(Long id);
    List<Worker> filterWorkers(String skill, String district);
    Worker updateWorker(Long id, Worker workerDetails); // 👈 Update Method
    void deleteWorker(Long id);
}
