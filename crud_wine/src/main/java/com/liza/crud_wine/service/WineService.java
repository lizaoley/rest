package com.liza.crud_wine.service;

import com.liza.crud_wine.entity.Wine;

import java.util.List;

public interface WineService {

    List<Wine> findAll();

    Wine findById(int id);

    Wine save(Wine wine);

    void deleteById(int id);

}
