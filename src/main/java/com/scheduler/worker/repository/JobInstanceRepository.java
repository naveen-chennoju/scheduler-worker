package com.scheduler.worker.repository;

import com.scheduler.worker.model.JobInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobInstanceRepository extends JpaRepository<JobInstance, Long> {

    List<JobInstance> findTop10ByStatusOrderByScheduledTimeAsc(String status);
}
