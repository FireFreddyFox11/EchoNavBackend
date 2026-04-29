package Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffID;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisations organisation;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    public int getStaffID() {
        return staffID;
    }
    public void setStaffID(int staffID) {
        this.staffID = staffID;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
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

    protected Staff() {}

    protected Staff(Builder<?> builder) {
        this.staffID = builder.staffID;
        this.organisation = builder.organisation;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> implements Serializable {
        protected int staffID;
        protected Organisations organisation;
        protected String name;
        protected String email;
        protected String password;
        protected String role;
        protected OffsetDateTime createdAt;
        protected OffsetDateTime updatedAt;

        public T StaffID(int staffID) {
            this.staffID = staffID;
            return self();
        }
        public T Organisations(Organisations organisation) {
            this.organisation = organisation;
            return self();
        }
        public T name(String name) {
            this.name = name;
            return self();
        }
        public T email(String email) {
            this.email = email;
            return self();
        }
        public T password(String password) {
            this.password = password;
            return self();
        }
        public T role(String role) {
            this.role = role;
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
        public T self() {
            return (T) this;
        }
        public Staff build() {
            return new Staff(this);
        }
    }
}
