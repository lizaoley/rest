package com.liza.crud_wine.service;

import com.liza.crud_wine.dao.WineRepository;
import com.liza.crud_wine.entity.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService{

    private WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> findAll() {
        return wineRepository.findAllByOrderByBrand(); // в таблице на странице высвечиваются в алфавитном порядке
    }

    @Override
    public Wine findById(int id) {
        Optional<Wine> employee = wineRepository.findById(id);

        Wine newEmployee = null;
        if (employee.isPresent()) {
            newEmployee = employee.get();
        } else {
            throw new RuntimeException("Wine with ID №" + id + " not found.");
        }
        return newEmployee;
    }

    @Override
    public Wine save(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public void deleteById(int id) {
        wineRepository.deleteById(id);
    }
}
