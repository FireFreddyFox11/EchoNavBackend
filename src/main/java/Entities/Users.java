package Entities;

import Enumerations.UserRole;
import com.nimbusds.openid.connect.sdk.assurance.evidences.Organization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

import static org.bouncycastle.oer.its.ieee1609dot2.SignerIdentifier.self;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", schema = "public")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userID;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisations organization;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "country")
    private String country;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "pin")
    private String pin;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    protected Users() {}

    protected Users(Builder<?> builder) {
        this.userID = builder.userID;
        this.organization = builder.organization;
        this.name = builder.name;
        this.surname = builder.surname;
        this.country = builder.country;
        this.email = builder.email;
        this.password = builder.password;
        this.pin = builder.pin;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected int userID;
        protected Organisations organization;
        protected String name;
        protected String surname;
        protected String country;
        protected String email;
        protected String password;
        protected String pin;

        public T userID(int userID) {
            this.userID = userID;
            return self();
        }

        public T organization(Organisations organization) {
            this.organization = organization;
            return self();
        }

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T surname(String surname) {
            this.surname = surname;
            return self();
        }

        public T country(String country) {
            this.country = country;
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

        public T pin(String pin) {
            this.pin = pin;
            return self();
        }

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public Users build() {
            return new Users(this);
        }
    }
}
