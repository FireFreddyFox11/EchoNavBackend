package Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.User;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "pairing_pin", schema = "public")
public class PairingPin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pin_id")
    private int pinID;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisations Organisations;
    @OneToMany
    @Column(name = "user_id")
    private List<Users> users;
    @OneToMany
    @Column(name = "generated_by_id")
    private List<Staff> staff;
    @Column(name = "pin")
    private String pin;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public int getPinID() {
        return pinID;
    }
    public void setPinID(int pinID) {
        this.pinID = pinID;
    }
    public Organisations getOrganisations() {
        return Organisations;
    }
    public void setOrganisations(Organisations Organisations) {
        this.Organisations = Organisations;
    }
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }
    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    protected PairingPin() {}

    public PairingPin(Builder<?> builder) {
        this.pinID = builder.pinID;
        this.Organisations = builder.organisations;
        this.users = builder.users;
        this.staff = builder.staff;
        this.pin = builder.pin;
        this.createdAt = builder.createdAt;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected int pinID;
        protected Organisations organisations;
        protected List<Users> users;
        protected List<Staff> staff;
        protected String pin;
        protected OffsetDateTime createdAt;

        public T pinID(int pinID) {
            this.pinID = pinID;
            return self();
        }
        public T organisations(Organisations organisations) {
            this.organisations = organisations;
            return self();
        }
        public T users(List<Users> users) {
            this.users = users;
            return self();
        }
        public T staff(List<Staff> staff) {
            this.staff = staff;
            return self();
        }
        public T pin(String pin) {
            this.pin = pin;
            return self();
        }
        public T createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return self();
        }
        @SuppressWarnings("unchecked")
        public T self() {
            return (T)this;
        }
        public PairingPin build() {
            return new PairingPin(this);
        }
    }
}
