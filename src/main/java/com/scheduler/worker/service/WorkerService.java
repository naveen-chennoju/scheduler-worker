package com.scheduler.worker.service;

import com.scheduler.worker.model.JobInstance;
import com.scheduler.worker.repository.JobInstanceRepository;
import io.lettuce.core.ScriptOutputType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkerService {

    private final JobInstanceRepository jobInstanceRepository;
    public WorkerService(JobInstanceRepository jobInstanceRepository) {
        this.jobInstanceRepository = jobInstanceRepository;
    }

    @Scheduled(fixedRate = 10000)
    public void pollJob() throws InterruptedException {
        List<JobInstance> jobInstances = jobInstanceRepository.findTop10ByStatusOrderByScheduledTimeAsc("PENDING");
        for (JobInstance jobInstance : jobInstances) {
            try {

                jobInstance.setStatus("RUNNING");
                jobInstance.setPickedAt(LocalDateTime.now());

                processJob(jobInstance);

                jobInstance.setStatus("SUCCESS");
                jobInstance.setCompletedAt(LocalDateTime.now());

                jobInstanceRepository.save(jobInstance);

            } catch (Exception e) {
                jobInstance.setStatus("FAILED");
            }
        }
    }

    public void processJob(JobInstance jobInstance) throws InterruptedException {
        System.out.println("Processing job instance " + jobInstance.getJobId());
        Thread.sleep(10000);
    }
}
