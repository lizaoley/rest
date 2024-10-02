package com.liza.crud;

import com.liza.crud.dao.PupilDAO;
import com.liza.crud.entity.Pupil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PupilDAO pupilDAO) {
        return runner -> {
            createPupil(pupilDAO);
//          readPupilInfo(pupilDAO);
//          getPupils(pupilDAO);
//          getLastNamePupil(pupilDAO);
//          updatePupil(pupilDAO);
//          deletePupil(pupilDAO);
//          deleteAllPupil(pupilDAO);

        };
    }

    private void createPupil(PupilDAO pupilDAO) {
        System.out.println("Creating new pupil");
        Pupil pupil = new Pupil("Pizza", "Dodo", "pizza@mail.ru");
        System.out.println("Saving pupil in database");
        pupilDAO.save(pupil);
        System.out.println("Pupil in database: \n\t" + pupil);
    }

    private void readPupilInfo(PupilDAO pupilDAO) {
        System.out.println("Reading pupil info");
        Pupil pupil = pupilDAO.findById(4);
        System.out.println("Pupil in database: \n\t" + pupil);
    }

    private void getPupils(PupilDAO pupilDAO) {
        System.out.println("Finding pupils");
        List<Pupil> pupils = pupilDAO.findAll();
        for (var p : pupils) {
            System.out.println(p);
        }
    }

    private void getLastNamePupil(PupilDAO pupilDAO) {
        System.out.println("Finding lastname pupil");
        List<Pupil> pupils = pupilDAO.findByLastName("Reiter");
        for (var p : pupils) {
            System.out.println(p);
        }
    }

    private void updatePupil(PupilDAO pupilDAO) {
        System.out.println("Updating pupil");
        Pupil pupil = pupilDAO.findById(2);
        System.out.println(pupil);

        System.out.println("Updating pupil in database");
        pupil.setFirstName("Liza");
        pupil.setEmail("lizareiter@mail.ru");

        System.out.println("Save pupil in database");
        pupilDAO.update(pupil);
        System.out.println(pupil);
    }

    private void deletePupil(PupilDAO pupilDAO) {
        System.out.println("Deleting pupil");
        int idForDelete = 3;
        System.out.println("Deleting pupil in database with id: " + idForDelete);
        pupilDAO.delete(idForDelete);
    }

    private void deleteAllPupil(PupilDAO pupilDAO) {
        System.out.println("Deleting All pupil");
        int x = pupilDAO.deleteAll();
        System.out.println("Всего удалено учеников - " + x);
    }

}
