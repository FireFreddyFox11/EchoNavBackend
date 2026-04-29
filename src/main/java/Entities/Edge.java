package Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "edge")
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edge_id")
    private int edgeId;
    @ManyToOne
    @JoinColumn(name = "floor_plan_id")
    private BuildingFloorPlan floorPlanId;
    @ManyToOne
    @JoinColumn(name = "from_node")
    private Nodes fromNode;
    @ManyToOne
    @JoinColumn(name = "to_node")
    private Nodes toNode;
    @Column(name = "distance")
    private double distance;
    @CreationTimestamp
    @Column(name = "distance")
    private OffsetDateTime distanceAt;

    public int getEdgeId() {
        return edgeId;
    }
    public void setEdgeId(int edgeId) {
        this.edgeId = edgeId;
    }
    public BuildingFloorPlan getFloorPlanId() {
        return floorPlanId;
    }
    public void setFloorPlanId(BuildingFloorPlan floorPlanId) {
        this.floorPlanId = floorPlanId;
    }
    public Nodes getFromNode() {
        return fromNode;
    }
    public void setFromNode(Nodes fromNode) {
        this.fromNode = fromNode;
    }
    public Nodes getToNode() {
        return toNode;
    }
    public void setToNode(Nodes toNode) {
        this.toNode = toNode;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public OffsetDateTime getDistanceAt() {
        return distanceAt;
    }
    public void setDistanceAt(OffsetDateTime distanceAt) {
        this.distanceAt = distanceAt;
    }

    protected Edge() {}

    public Edge(Builder<?> builder) {
        this.edgeId = builder.edgeId;
        this.floorPlanId = builder.floorPlanId;
        this.fromNode = builder.fromNode;
        this.toNode = builder.toNode;
        this.distance = builder.distance;
        this.distanceAt = builder.distanceAt;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected int edgeId;
        protected BuildingFloorPlan floorPlanId;
        protected Nodes fromNode;
        protected Nodes toNode;
        protected double distance;
        protected OffsetDateTime distanceAt;

        public T edgeId(int edgeId) {
            this.edgeId = edgeId;
            return self();
        }
        public T floorPlanId(BuildingFloorPlan floorPlanId) {
            this.floorPlanId = floorPlanId;
            return self();
        }
        public T fromNode(Nodes fromNode) {
            this.fromNode = fromNode;
            return self();
        }
        public T toNode(Nodes toNode) {
            this.toNode = toNode;
            return self();
        }
        public T distance(double distance) {
            this.distance = distance;
            return self();
        }
        public T distanceAt(OffsetDateTime distanceAt) {
            this.distanceAt = distanceAt;
            return self();
        }

        @SuppressWarnings("unchecked")
        public T self() {
            return (T) this;
        }

        public Edge build() {
            return new Edge(this);
        }
    }
}
