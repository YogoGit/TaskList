package services;

import datamodels.Task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Concrete implementation of the {@TaskService} which utilizes an injected {@link @PersistenceContext persistence} context for adding and retrieving tasks.
 *
 * @author afrieze
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void addTask(Task task) {
        em.persist(task);
    }

    @Override
    public List<Task> getAllTasks() {
        CriteriaQuery<Task> c = em.getCriteriaBuilder().createQuery(Task.class);
        c.from(Task.class);
        return em.createQuery(c).getResultList();
    }

}
