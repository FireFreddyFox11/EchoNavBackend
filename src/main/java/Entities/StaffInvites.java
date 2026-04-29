package Entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "staff_invite")
public class StaffInvites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    private int inviteID;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organisations organisation;
    @ManyToOne
    @JoinColumn(name = "invited_by_id")
    private Staff staff;
    @Column(name = "invite_date")
    private OffsetDateTime inviteDate;

    public int getInviteID() {
        return inviteID;
    }
    public void setInviteID(int inviteID) {
        this.inviteID = inviteID;
    }
    public Organisations getOrganisation() {
        return organisation;
    }
    public void setOrganisation(Organisations organisation) {
        this.organisation = organisation;
    }
    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    public OffsetDateTime getInviteDate() {
        return inviteDate;
    }
    public void setInviteDate(OffsetDateTime inviteDate) {
        this.inviteDate = inviteDate;
    }

    protected StaffInvites() {}

    protected StaffInvites(Builder<?> builder) {
        this.inviteID = builder.inviteID;
        this.organisation = builder.organisation;
        this.staff = builder.staff;
        this.inviteDate = builder.inviteDate;
    }

    public static class Builder<T extends Builder<T>> {
        protected int inviteID;
        protected Organisations organisation;
        protected Staff staff;
        protected OffsetDateTime inviteDate;

        public T inviteID(int inviteID) {
            this.inviteID = inviteID;
            return self();
        }
        public T organisation(Organisations organisation) {
            this.organisation = organisation;
            return self();
        }
        public T staff(Staff staff) {
            this.staff = staff;
            return self();
        }
        public T inviteDate(OffsetDateTime inviteDate) {
            this.inviteDate = inviteDate;
            return self();
        }
        @SuppressWarnings("unchecked")
        public T self() {
            return (T) this;
        }
        public StaffInvites build() {return new StaffInvites(this);}
    }
}
