package Queries;

import Entities.Organisations;
import Entities.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffQueries {
    @PersistenceContext
    private EntityManager em;

    @Query
    public Staff findUserByStaffId(int sID) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.staffID = :sID", Staff.class)
                .setParameter("sID", sID)
                .getSingleResult();
    }
    @Query
    public Staff findUserByOrgId(Organisations oID) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.organisation = :organisation", Staff.class)
                .setParameter("organisation", oID)
                .getSingleResult();
    }
    @Query
    public Staff findUserByName(String name) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.name = :name", Staff.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    @Query
    public Staff findUserByEmail(String email) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.email = :email", Staff.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    @Query
    public Staff findUserByRole(String role) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.role = :role", Staff.class)
                .setParameter("role", role)
                .getSingleResult();
    }
    @Query
    public List<Staff> findUsersByStaffId(int sID) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.staffID = :sID", Staff.class)
                .setParameter("sID", sID)
                .getResultList();
    }
    @Query
    public List<Staff> findUsersByOrgId(Organisations oID) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.organisation = :organisation", Staff.class)
                .setParameter("organisation", oID)
                .getResultList();
    }
    @Query
    public List<Staff> findUsersByName(String name) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.name = :name", Staff.class)
                .setParameter("name", name)
                .getResultList();
    }
    @Query
    public List<Staff> findUsersByEmail(String email) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.email = :email", Staff.class)
                .setParameter("email", email)
                .getResultList();
    }
    @Query
    public List<Staff> findUsersByRole(String role) {
        return em.createQuery("SELECT s FROM Staff s WHERE s.role = :role", Staff.class)
                .setParameter("role", role)
                .getResultList();
    }
}
