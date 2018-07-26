package com.selectcv.repository;

import org.springframework.data.repository.CrudRepository;

import com.selectcv.model.CountryList;

public interface CountryRepository extends CrudRepository<CountryList, Integer> {

}
