package com.borzdykooa.dao;

import com.borzdykooa.entity.Trainer;
import com.borzdykooa.util.SessionFactoryManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/*
Класс, содержащий метод save и find для таблицы trainer
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TrainerDao {

    private static final TrainerDao INSTANCE = new TrainerDao();
    private static final Logger log = Logger.getLogger(TrainerDao.class);
    private static final SessionFactory SESSION_FACTORY = SessionFactoryManager.getSessionFactory();

    public Trainer find(Long id) {
        log.info("Method find is called in TrainerDao");
        try (Session session = SESSION_FACTORY.openSession()) {
            Trainer trainer = session.find(Trainer.class, id);
            if (trainer != null) {
                log.info(trainer.toString() + " has been found");
            }
            return trainer;
        }
    }

    public Long save(Trainer trainer) {
        log.info("Method save is called in TrainerDao");
        try (Session session = SESSION_FACTORY.openSession()) {
            session.beginTransaction();
            Serializable id = session.save(trainer);
            session.getTransaction().commit();
            if (id != null) {
                log.info(trainer.toString() + " has been saved successfully!");
            }
            return (Long) id;
        }
    }

    public static TrainerDao getInstance() {
        return INSTANCE;
    }
}
