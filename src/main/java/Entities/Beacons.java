package Entities;

import Enumerations.BeaconStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "beacons")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beacons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beacon_id")
    private int beaconId;
    @OneToOne
    @JoinColumn(name = "node_id")
    private Nodes node;
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "major")
    private String major;
    @Column(name = "minor")
    private String minor;
    @Column(name = "rssi_baseline")
    private String rssiBaseline;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BeaconStatus status;
    @DateTimeFormat
    @Column(name = "linked_date")
    private LocalDate linkedDate;

    public int getBeaconId() {
        return beaconId;
    }
    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }
    public Nodes getNode() {
        return node;
    }
    public void setNode(Nodes node) {
        this.node = node;
    }
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getMinor() {
        return minor;
    }
    public void setMinor(String minor) {
        this.minor = minor;
    }
    public String getRssiBaseline() {
        return rssiBaseline;
    }
    public void setRssiBaseline(String rssiBaseline) {
        this.rssiBaseline = rssiBaseline;
    }
    public BeaconStatus getStatus() {
        return status;
    }
    public void setStatus(BeaconStatus status) {
        this.status = status;
    }
    public LocalDate getLinkedDate() {
        return linkedDate;
    }
    public void setLinkedDate(LocalDate linkedDate) {
        this.linkedDate = linkedDate;
    }

    protected Beacons(Builder<?> builder) {
        this.beaconId = builder.beaconId;
        this.uuid = builder.uuid;
        this.major = builder.major;
        this.minor = builder.minor;
        this.rssiBaseline = builder.rssiBaseline;
        this.status = builder.status;
        this.linkedDate = builder.linkedDate;
    }

    public static Builder<?> builder() {
        return new Builder<>();
    }

    public static class Builder<T extends Builder<T>> {
        protected int beaconId;
        protected UUID uuid;
        protected String major;
        protected String minor;
        protected String rssiBaseline;
        protected BeaconStatus status;
        protected LocalDate linkedDate;

        public T beaconId(int beaconId) {
            this.beaconId = beaconId;
            return self();
        }
        public T uuid(UUID uuid) {
            this.uuid = uuid;
            return self();
        }
        public T major(String major) {
            this.major = major;
            return self();
        }
        public T minor(String minor) {
            this.minor = minor;
            return self();
        }
        public T rssiBaseline(String rssiBaseline) {
            this.rssiBaseline = rssiBaseline;
            return self();
        }
        public T status(BeaconStatus status) {
            this.status = status;
            return self();
        }
        public T linkedDate(LocalDate linkedDate) {
            this.linkedDate = linkedDate;
            return self();
        }

        @SuppressWarnings("unchecked")
        public T self() {
            return (T) this;
        }

        public Beacons build() {
            return new Beacons(this);
        }
    }
}
