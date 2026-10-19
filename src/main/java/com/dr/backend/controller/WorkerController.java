package com.dr.backend.controller;

import com.dr.backend.interfaces.WorkerService;
import com.dr.backend.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    // 1. Add Worker (POST)
    @PostMapping
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        Worker saved = workerService.addWorker(worker);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 2. Get All Workers (GET)
    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workerService.getAllWorkers());
    }

    // 3. Get Worker by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        return ResponseEntity.ok(workerService.getWorkerById(id));
    }

    // 4. Filter Workers by Skill and/or District (GET)
    // Example: /api/workers/filter?skill=ELECTRICIAN&district=Patna
    @GetMapping("/filter")
    public ResponseEntity<List<Worker>> filterWorkers(
            @RequestParam(required = false) String skill,
            @RequestParam(required = false) String district
    ) {
        return ResponseEntity.ok(workerService.filterWorkers(skill, district));
    }

    // 5. 🔥 UPDATE WORKER (PUT)
    // Example: PUT /api/workers/1
    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(
            @PathVariable Long id,
            @RequestBody Worker workerDetails
    ) {
        Worker updatedWorker = workerService.updateWorker(id, workerDetails);
        return ResponseEntity.ok(updatedWorker);
}
    // 6. Delete Worker (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok("Worker deleted successfully with ID: " + id);
    }

}
