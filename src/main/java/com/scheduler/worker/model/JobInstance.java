package com.scheduler.worker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_instances")
public class JobInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    private LocalDateTime scheduledTime;

    private LocalDateTime pickedAt;

    private LocalDateTime completedAt;

    private String status;   // PENDING, RUNNING, SUCCESS, FAILED

    private String logs;

    private Integer retryCount;
}

