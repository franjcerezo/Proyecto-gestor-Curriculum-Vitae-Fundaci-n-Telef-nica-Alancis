package com.selectcv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectcv.model.Experience;
import com.selectcv.model.User;
import com.selectcv.repository.ExperienceRepository;
import com.selectcv.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepository experienceRepository;

	@Override
	public Experience save(Experience experience) {
		return experienceRepository.save(experience);
	}

	@Override
	public Boolean delete(int id) {
		if (experienceRepository.existsById(id)) {
			experienceRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Experience update(Experience experience) {
		return experienceRepository.save(experience);
	}

	@Override
	public Experience findById(int id) {
		return experienceRepository.findById(id);
	}

	@Override
	public List<Experience> findByUser(User user) {
		return (List<Experience>) experienceRepository.findByUser(user);
	}

	@Override
	public List<Experience> findAll() {
		return (List<Experience>) experienceRepository.findAll();
	}

	@Override
	public List<Experience> findBetween(int start, int end) {
		// TODO Auto-generated method stub
		return experienceRepository.findBetween(start, end);
	}

}
