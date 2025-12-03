                  ┌───────────────────┐
                  │  Scheduler-Core   │
                  │ Creates JobInstances │
                  └─────────┬─────────┘
                            │
                            ▼
                  ┌───────────────────┐
                  │ JobInstance Table │
                  │  (status: PENDING)│
                  └─────────┬─────────┘
                            │
                            ▼
          ┌─────────────────────────────────┐
          │         Worker Module           │
          │ - Polls PENDING jobs            │
          │ - Executes job                  │
          │ - Updates status & logs        │
          └─────────────────────────────────┘
                            │
                            ▼
                  ┌───────────────────┐
                  │ Updated JobInstance│
                  │ SUCCESS / FAILED  │
                  └───────────────────┘

Potential Issues if multiple workers run:
- Duplicate job execution
- Race conditions on status updates
- Lost or overwritten logs
- Database conflicts
