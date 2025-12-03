# Scheduler-Worker Module
## Project Overview

Step 1. This repository contains the worker module of a distributed job scheduler:

Step 2. Polls the database for PENDING job instances created by the scheduler-core module.

Step 3. Executes each job sequentially and updates its status in the database.

Step 4. Tracks execution logs and updates the job instance to SUCCESS or FAILED.

_Currently, this worker is designed for a single worker instance. Multi-worker execution issues are being investigated._
