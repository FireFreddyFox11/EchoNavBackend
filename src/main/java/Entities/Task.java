package Entities;

import Enumerations.TaskStatus;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;
    @OneToMany
    @JoinColumn(name = "staff_id")
    private List<Staff> assignedToStaff;
    @OneToMany
    @JoinColumn(name = "node_id")
    private List<Nodes> nodes;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "time_completed")
    private OffsetDateTime timeCompleted;
    @Column(name = "time_assigned")
    private OffsetDateTime timeAssigned;

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public List<Staff> getAssignedToStaff() {
        return assignedToStaff;
    }
    public void setAssignedToStaff(List<Staff> assignedToStaff) {
        this.assignedToStaff = assignedToStaff;
    }
    public List<Nodes> getNodes() {
        return nodes;
    }
    public void setNodes(List<Nodes> nodes) {
        this.nodes = nodes;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public OffsetDateTime getTimeCompleted() {
        return timeCompleted;
    }
    public void setTimeCompleted(OffsetDateTime timeCompleted) {
        this.timeCompleted = timeCompleted;
    }
    public OffsetDateTime getTimeAssigned() {
        return timeAssigned;
    }
    public void setTimeAssigned(OffsetDateTime timeAssigned) {
        this.timeAssigned = timeAssigned;
    }

    protected Task() {}

    protected Task(Builder<?> builder) {
        this.taskId = builder.taskId;
        this.assignedToStaff = builder.assignedToStaff;
        this.nodes = builder.nodes;
        this.status = builder.status;
        this.timeCompleted = builder.timeCompleted;
        this.timeAssigned = builder.timeAssigned;
    }

    public static class Builder<T extends Builder<T>> {
        protected int  taskId;
        protected List<Staff> assignedToStaff;
        protected List<Nodes> nodes;
        protected TaskStatus status;
        protected OffsetDateTime timeCompleted;
        protected OffsetDateTime timeAssigned;
        public T TaskId(int taskId) {
            this.taskId = taskId;
            return self();
        }
        public T AssignedToStaff(List<Staff> assignedToStaff) {
            this.assignedToStaff = assignedToStaff;
            return self();
        }
        public T Nodes(List<Nodes> nodes) {
            this.nodes = nodes;
            return self();
        }
        public T Status(TaskStatus status) {
            this.status = status;
            return self();
        }
        public T TimeCompleted(OffsetDateTime timeCompleted) {
            this.timeCompleted = timeCompleted;
            return self();
        }
        public T TimeAssigned(OffsetDateTime timeAssigned) {
            this.timeAssigned = timeAssigned;
            return self();
        }
        @SuppressWarnings("unchecked")
        public T self() {
            return (T) this;
        }
        public Task build() {return new Task(this);}
    }
}
