package Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "org_buildings")
public class Buildings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_building_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisations organisation;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Organisations getOrganisation() {
        return organisation;
    }
    public void setOrganisation(Organisations organisation) {
        this.organisation = organisation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public Buildings(Builder<?> builder) {
        this.organisation = builder.organisation;
        this.name = builder.name;
        this.address = builder.address;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected Organisations organisation;
        protected String name;
        protected String address;
        protected OffsetDateTime createdAt;
        protected OffsetDateTime updatedAt;

        public T organisation(Organisations organisation) {
            this.organisation = organisation;
            return self();
        }
        public T name(String name) {
            this.name = name;
            return self();
        }
        public T address(String address) {
            this.address = address;
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
        @SuppressWarnings("unchecked")
        public T self() {return (T) this;}

        public Buildings build() {
            return new Buildings(this);
        }
    }
}
