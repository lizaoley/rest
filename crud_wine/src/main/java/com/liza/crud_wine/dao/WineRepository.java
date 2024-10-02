package com.liza.crud_wine.dao;

import com.liza.crud_wine.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer> {

    public List<Wine> findAllByOrderByBrand();
}
