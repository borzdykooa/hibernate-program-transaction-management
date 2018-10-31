package com.borzdykooa;

import com.borzdykooa.dao.TraineeDao;
import com.borzdykooa.dao.TrainerDao;
import com.borzdykooa.entity.Trainee;
import com.borzdykooa.entity.Trainer;

/*
Класс для демонстрации работы приложения
 */
public class Demo {

    public static void main(String[] args) {
        Trainer andreiReut = new Trainer("Andrei Reut", "Java", 6);
        Trainer ivanIshchenko = new Trainer("Ivan Ishchenko", "Java", 6);
        TrainerDao.getInstance().save(andreiReut);
        TrainerDao.getInstance().save(ivanIshchenko);

        Trainer savedAndreiReut = TrainerDao.getInstance().find(1L);
        Trainer savedIvanIshchenko = TrainerDao.getInstance().find(2L);
        Trainee olgaBorzdyko = new Trainee("Olga Borzdyko", savedIvanIshchenko);
        Trainee denisByhovsky = new Trainee("Denis Byhovsky", savedAndreiReut);
        TraineeDao.getInstance().save(olgaBorzdyko);
        TraineeDao.getInstance().save(denisByhovsky);

        TraineeDao.getInstance().findAll();
    }
}
