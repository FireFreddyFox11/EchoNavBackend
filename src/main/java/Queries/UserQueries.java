package Queries;

import Entities.Organisations;
import Entities.Users;
import Enumerations.UserRole;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQueries {
    @PersistenceContext
    private EntityManager em;

    @Query
    public List<Users> getUsers() {
        return em.createQuery("SELECT u FROM Users u", Users.class).getResultList();
    }

    @Query
    public List<Users> findUsersById(int userID){
        return em.createQuery("SELECT u FROM Users u WHERE u.userID = :userID", Users.class)
                .setParameter("userID", userID)
                .getResultList();
    }
    @Query
    public List<Users> findUsersByEmail(String email){
        return em.createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class)
                .setParameter("email", email)
                .getResultList();
    }
    @Query
    public List<Users> findUsersByOrganisation(Organisations organisation){
        return em.createQuery("SELECT u FROM Users u WHERE u.organization = :organisation", Users.class)
                .setParameter("organisation", organisation)
                .getResultList();
    }
    @Query
    public List<Users> findUsersByPin(String pin){
        return em.createQuery("SELECT u FROM Users u WHERE u.pin = :pin", Users.class)
                .setParameter("pin", pin)
                .getResultList();
    }
    @Query
    public Users findUserById(int userID){
        return em.createQuery("SELECT u FROM Users u WHERE u.userID = :userID", Users.class)
                .setParameter("userID", userID)
                .getSingleResult();
    }
    @Query
    public Users findUserByEmail(String email){
        return em.createQuery("SELECT u FROM Users u WHERE u.email = :email", Users.class)
                .setParameter("email", email)
                .getSingleResult();
    }
    @Query
    public Users findUserByOrganisation(Organisations organisation){
        return em.createQuery("SELECT u FROM Users u WHERE u.organization = :organisation", Users.class)
                .setParameter("organisation", organisation)
                .getSingleResult();
    }
    @Query
    public Users findUserByPin(String pin){
        return em.createQuery("SELECT u FROM Users u WHERE u.pin = :pin", Users.class)
                .setParameter("pin", pin)
                .getSingleResult();
    }
    @Query
    public void save(Users user){
        em.persist(user);
    }

}
