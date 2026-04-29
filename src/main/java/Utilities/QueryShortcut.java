package Utilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryShortcut<T> {
    @PersistenceContext
    private EntityManager em;
    private final CriteriaBuilder cb = em.getCriteriaBuilder();

    public List<T> findByValues(Class<T> DataClass, String fieldName, Object data) {
        CriteriaQuery<T> cq = cb.createQuery(DataClass);
        Root<T> root = cq.from(DataClass);
        CriteriaQuery<T> query = cq.select(root).where(cb.equal(root.get(fieldName), data));
        return em.createQuery(query).getResultList();
    }
}
