package Entities;

import Enumerations.AccessType;
import jakarta.persistence.*;
import Enumerations.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "organisation", schema = "public")
public class Organisations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private int orgID;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "slug")
    private String slug;
    @Column(name = "country")
    private String country;
    @Column(name = "org_contact_no")
    private String orgContactNo;
    @Column(name = "org_email")
    private String orgEmail;
    @Column(name = "org_password")
    private String orgPassword;
    @Column(name = "access")
    @Enumerated(EnumType.STRING)
    private AccessType accessType;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    protected Organisations() {}

    public int getOrgID() {
        return orgID;
    }
    public void setOrgID(int orgID) {
        this.orgID = orgID;
    }
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getOrgContactNo() {
        return orgContactNo;
    }
    public void setOrgContactNo(String orgContactNo) {
        this.orgContactNo = orgContactNo;
    }
    public String getOrgEmail() {
        return orgEmail;
    }
    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
    public String getOrgPassword() {
        return orgPassword;
    }
    public void setOrgPassword(String orgPassword) {
        this.orgPassword = orgPassword;
    }
    public AccessType getAccessType() {
        return accessType;
    }
    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
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

    public Organisations(Builder<?> builder) {
        this.orgID = builder.orgID;
        this.orgName = builder.orgName;
        this.adminName = builder.adminName;
        this.slug = builder.slug;
        this.country = builder.country;
        this.orgContactNo = builder.orgContactNo;
        this.orgEmail = builder.orgEmail;
        this.orgPassword = builder.orgPassword;
        this.accessType = builder.accessType;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>>{
        private int orgID;
        private String orgName;
        private String adminName;
        private String slug;
        private String country;
        private String orgContactNo;
        private String orgEmail;
        private String orgPassword;
        private AccessType accessType;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;

        public T OrgID(int orgID) {
            this.orgID = orgID;
            return self();
        }
        public T OrgName(String orgName) {
            this.orgName = orgName;
            return self();
        }
        public T AdminName(String adminName) {
            this.adminName = adminName;
            return self();
        }
        public T slug(String slug) {
            this.slug = slug;
            return self();
        }
        public T country(String country) {
            this.country = country;
            return self();
        }
        public T orgContactNo(String orgContactNo) {
            this.orgContactNo = orgContactNo;
            return self();
        }
        public T orgEmail(String orgEmail) {
            this.orgEmail = orgEmail;
            return self();
        }
        public T orgPassword(String orgPassword) {
            this.orgPassword = orgPassword;
            return self();
        }
        public T accessType(AccessType accessType) {
            this.accessType = accessType;
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
        public Organisations build() {
            return new Organisations(this);
        }
    }
}
