package Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "nodes")
public class Nodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "floor_plan_id")
    private BuildingFloorPlan floorPlanId;
    @Column(name = "label")
    private String label;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @Column(name = "is_hazard")
    private boolean isHazard;
    @Column(name = "tts_label")
    private String ttsLabel;
    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
