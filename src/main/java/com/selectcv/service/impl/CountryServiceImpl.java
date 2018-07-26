package com.selectcv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectcv.model.CountryList;
import com.selectcv.repository.CountryRepository;
import com.selectcv.service.CountryService;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<CountryList> findAll() {
		return (List<CountryList>) countryRepository.findAll();
	}
}
