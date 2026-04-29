package Entities;

import jakarta.persistence.*;
import Enumerations.AccessType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "building_floor_plans")
public class BuildingFloorPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_plan_id")
    private int floorPlanId;
    @ManyToOne
    @JoinColumn(name = "org_building_id")
    private Buildings buildings;
    @Column(name = "name")
    private String name;
    @Column(name = "floor_plan_link")
    private String floorPlanLink;
    @Column(name = "scale")
    private float scale;
    @Enumerated(EnumType.STRING)
    @Column(name = "access")
    private AccessType access;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    public int getFloorPlanId() {
        return floorPlanId;
    }
    public void setFloorPlanId(int floorPlanId) {
        this.floorPlanId = floorPlanId;
    }
    public Buildings getBuildings() {
        return buildings;
    }
    public void setBuildings(Buildings buildings) {
        this.buildings = buildings;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFloorPlanLink() {
        return floorPlanLink;
    }
    public void setFloorPlanLink(String floorPlanLink) {
        this.floorPlanLink = floorPlanLink;
    }
    public float getScale() {
        return scale;
    }
    public void setScale(float scale) {
        this.scale = scale;
    }
    public AccessType getAccess() {
        return access;
    }
    public void setAccess(AccessType access) {
        this.access = access;
    }
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    protected BuildingFloorPlan() {}

    public BuildingFloorPlan(Builder<?> builder) {
        this.floorPlanId = builder.floorPlanId;
        this.buildings = builder.buildings;
        this.name = builder.name;
        this.floorPlanLink = builder.floorPlanLink;
        this.scale = builder.scale;
        this.access = builder.access;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder<?>  builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected int floorPlanId;
        protected Buildings buildings;
        protected String name;
        protected String floorPlanLink;
        protected float scale;
        protected AccessType access;
        protected OffsetDateTime createdAt;
        protected OffsetDateTime updatedAt;

        public T floorPlanId(int floorPlanId) {
            this.floorPlanId = floorPlanId;
            return self();
        }
        public T buildings(Buildings buildings) {
            this.buildings = buildings;
            return self();
        }
        public T name(String name) {
            this.name = name;
            return self();
        }
        public T floorPlanLink(String floorPlanLink) {
            this.floorPlanLink = floorPlanLink;
            return self();
        }
        public T scale(float scale) {
            this.scale = scale;
            return self();
        }
        public T createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return self();
        }
        public T updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return self();
        }
        public T access(AccessType access) {
            this.access = access;
            return self();
        }

        @SuppressWarnings("unchecked")
        public T self() {
            return (T) this;
        }

        public BuildingFloorPlan build() {
            return new BuildingFloorPlan(this);
        }
    }
}
