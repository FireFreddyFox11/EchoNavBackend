package Queries;

import Entities.Beacons;
import Entities.Nodes;
import Utilities.QueryShortcut;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeaconQueries {
    @PersistenceContext
    private EntityManager em;

    @Query
    public List<Beacons> findBeaconsById(int id) {
        return new QueryShortcut<Beacons>().findByValues(Beacons.class, "id", id);
    }
    @Query
    public List<Beacons> findBeaconsByNode(Nodes node) {
        return new QueryShortcut<Beacons>().findByValues(Beacons.class, "node", node);
    }
    @Query
    public List<Beacons> findBeaconsByUUId(int UUId) {
        return new QueryShortcut<Beacons>().findByValues(Beacons.class, "beaconId", UUId);
    }
    @Query
    public List<Beacons> findBeaconsByStatus(String Status) {
        return new QueryShortcut<Beacons>().findByValues(Beacons.class, "status", Status);
    }
    @Query
    public Beacons findBeaconById(int id) {
        return em.createQuery("SELECT b from Beacons b WHERE b.beaconId = :id", Beacons.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Query
    public Beacons findBeaconByNode(Nodes node) {
        return em.createQuery("SELECT b from Beacons b WHERE b.node = :node", Beacons.class)
                .setParameter("node", node)
                .getSingleResult();
    }
    @Query
    public Beacons findBeaconByUUId(int UUId) {
        return em.createQuery("SELECT b from Beacons b WHERE b.uuid = :UUId", Beacons.class)
                .setParameter("UUId", UUId)
                .getSingleResult();
    }
    @Query
    public Beacons findBeaconByStatus(String Status) {
        return em.createQuery("SELECT b from Beacons b WHERE b.status = :Status", Beacons.class)
                .setParameter("Status", Status)
                .getSingleResult();
    }
    @Query
    public void saveBeacon(Beacons beacon) {
        em.persist(beacon);
    }
    @Query
    public void updateBeacon(Beacons beacon) {
        em.merge(beacon);
    }
    @Query
    public void deleteBeacon(Beacons beacon) {
        em.remove(beacon);
    }
}
