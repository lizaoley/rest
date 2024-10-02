package com.liza.crud.dao;

import com.liza.crud.entity.Pupil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PupilDAOImpl implements PupilDAO {

    private EntityManager em;

    @Autowired
    public PupilDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Pupil pupil) {
        em.persist(pupil);
    }

    @Override
    public Pupil findById(int id) {
        return em.find(Pupil.class, id);
    }

    @Override
    public List<Pupil> findAll() {
        TypedQuery<Pupil> query = em.createQuery("from Pupil order by lastName", Pupil.class); // сортировка по фамилии
        List<Pupil> pupils = query.getResultList();
        return pupils;
//        return em.createQuery("from Pupil", Pupil.class).getResultList(); можно и так сделать по короче
    }

    @Override
    public List<Pupil> findByLastName(String lastName) {
        TypedQuery<Pupil> query = em.createQuery("from Pupil where lastName =: lastName", Pupil.class);
        query.setParameter("lastName", lastName);
        List<Pupil> pupils = query.getResultList();
        return pupils;
    }

    @Override
    @Transactional
    public void update(Pupil pupil) {
        em.merge(pupil);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Pupil pupil = em.find(Pupil.class, id);
        if (pupil != null) {
            em.remove(pupil);
            System.out.println("Delete success");
        } else {
            System.out.println("Delete failed");
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        int x = em.createQuery("delete from Pupil").executeUpdate(); // количество удаленных учеников
        return x;
    }


}
