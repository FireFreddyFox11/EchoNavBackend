package Queries;

import Entities.Beacons;
import Entities.Organisations;
import Enumerations.AccessType;
import Utilities.QueryShortcut;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganisationQueries {
    @PersistenceContext
    private EntityManager em;

    @Query
    public Organisations findOrganisationById(int id) {
        return em.createQuery("SELECT o FROM Organisations o WHERE o.orgID = :id", Organisations.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Query
    public Organisations findOrganisationByName(String name) {
        return em.createQuery("SELECT o FROM Organisations o WHERE o.orgName = :name", Organisations.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    @Query
    public Organisations findOrganisationByAccessType(AccessType accessType) {
        return em.createQuery("SELECT o FROM Organisations o WHERE o.accessType = :accessType", Organisations.class)
                .setParameter("accessType", accessType)
                .getSingleResult();
    }
    @Query
    public Organisations findOrganisationByCountry(String country) {
        return em.createQuery("SELECT o FROM Organisations o WHERE o.country = :country", Organisations.class)
                .setParameter("country", country)
                .getSingleResult();
    }
    @Query
    public List<Organisations> getOrganisations() {
        return em.createQuery("SELECT o FROM Organisations o", Organisations.class).getResultList();
    }
    @Query
    public List<Organisations> findOrganisationsByAccessType(AccessType accessType) {
        return new QueryShortcut<Organisations>().findByValues(Organisations.class, "accessType", accessType);
    }
    @Query
    public List<Organisations> findOrganisationsByCountry(String country) {
        return new QueryShortcut<Organisations>().findByValues(Organisations.class, "country", country);
    }
    @Query
    public void save(Organisations organisations) {
        em.persist(organisations);
    }
}
