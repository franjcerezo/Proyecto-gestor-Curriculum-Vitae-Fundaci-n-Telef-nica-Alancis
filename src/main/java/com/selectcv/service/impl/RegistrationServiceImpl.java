package com.selectcv.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectcv.model.Registration;
import com.selectcv.repository.RegistrationRepository;
import com.selectcv.service.RegistrationService;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public Registration save(Registration registration) {
		return registrationRepository.save(registration);
	}

}
