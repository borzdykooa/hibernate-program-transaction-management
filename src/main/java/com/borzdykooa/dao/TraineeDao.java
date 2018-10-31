package com.borzdykooa.dao;

import com.borzdykooa.entity.Trainee;
import com.borzdykooa.util.SessionFactoryManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/*
Класс, содержащий метод save для таблицы trainee
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TraineeDao {

    private static final TraineeDao INSTANCE = new TraineeDao();
    private static final Logger log = Logger.getLogger(TraineeDao.class);
    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    public Long save(Trainee trainee) {
        log.info("Method save is called in TraineeDao");
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            Serializable id = session.save(trainee);
            session.getTransaction().commit();
            if (id != null) {
                log.info(trainee.toString() + " has been saved successfully!");
            }
            return (Long) id;
        }
    }

    public List<Trainee> findAll() {
        log.info("Method findAll is called in TraineeDao");
        try (Session session = SESSION_FACTORY.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Trainee> criteria = cb.createQuery(Trainee.class);
            Root<Trainee> root = criteria.from(Trainee.class);
            criteria.select(root);
            List<Trainee> list = session.createQuery(criteria).list();
            if (list.size() > 0) {
                log.info("List of Trainees: " + list.toString());
            } else {
                log.info("List of Trainees is empty");
            }
            return list;
        }
    }

    public static TraineeDao getInstance() {
        return INSTANCE;
    }
}
