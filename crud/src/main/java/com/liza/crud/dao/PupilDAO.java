package com.liza.crud.dao;

import com.liza.crud.entity.Pupil;

import java.util.List;

public interface PupilDAO {

    void save(Pupil pupil);

    Pupil findById(int id);

    List<Pupil> findAll();

    List<Pupil> findByLastName(String lastName);

    void update(Pupil pupil);

    void delete(int id);

    int deleteAll();

}
