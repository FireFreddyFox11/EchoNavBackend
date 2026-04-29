package Queries;

import Entities.StaffInvites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class InvitesQueries {
    @PersistenceContext
    private EntityManager em;

    @Query
    public StaffInvites findInvitesByStaffID(int staffID){
        return em.createQuery("SELECT i FROM StaffInvites i WHERE i.inviteID = :staffID", StaffInvites.class)
                .setParameter("staffID", staffID)
                .getSingleResult();
    }
    
}
