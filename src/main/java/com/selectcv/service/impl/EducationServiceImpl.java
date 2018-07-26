package com.selectcv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectcv.model.Education;
import com.selectcv.model.User;
import com.selectcv.repository.EducationRepository;
import com.selectcv.service.EducationService;

@Service
@Transactional
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;

	@Override
	public Education save(Education education) {
		return educationRepository.save(education);
	}

	@Override
	public Boolean delete(int id) {
		if (educationRepository.existsById(id)) {
			educationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Education update(Education education) {
		return educationRepository.save(education);
	}

	@Override
	public Education findById(int id) {
		return educationRepository.findById(id);
	}

	@Override
	public List<Education> findByUser(User user) {
		return (List<Education>) educationRepository.findByUser(user);
	}

	@Override
	public List<Education> findAll() {
		return (List<Education>) educationRepository.findAll();
	}

//	@Override
//	public List<Education> findByStatus(String status) {
//		return educationRepository.findByStatus(status);
//	}
//
//	@Override
//	public List<Education> findByUserIdStatus(int userId, String status) {
//		// return taskRepository.findByUserIdStatus(userId, status);
//		return educationRepository.findByUserIdAndStatus(userId, status);
//	}

	@Override
	public List<Education> findBetween(int start, int end) {
		return educationRepository.findBetween(start, end);
	}

}
