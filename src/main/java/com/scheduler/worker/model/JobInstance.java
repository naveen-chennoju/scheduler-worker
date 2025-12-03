package com.scheduler.worker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "job_instance")
public class JobInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID jobId;

    private LocalDateTime scheduledTime;

    private LocalDateTime pickedAt;

    private LocalDateTime completedAt;

    private String status;   // PENDING, RUNNING, SUCCESS, FAILED

    private Integer retryCount;


    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobId='" + jobId + '\'' +
                ", scheduledTime='" + scheduledTime + '\'' +
                ", pickedAt=" + pickedAt +
                ", completedAt=" + completedAt +
                ", status='" + status + '\'' +
                ", retryCount=" + retryCount +
                '}';
    }
}

