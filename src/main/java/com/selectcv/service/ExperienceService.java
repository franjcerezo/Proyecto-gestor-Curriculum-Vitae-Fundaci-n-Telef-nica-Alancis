package com.selectcv.service;

import java.util.List;

import com.selectcv.model.Experience;
import com.selectcv.model.User;

public interface ExperienceService {

	Experience save(Experience experience);

	Boolean delete(int id);

	Experience update(Experience experience);

	Experience findById(int id);

	List<Experience> findByUser(User user);

	List<Experience> findAll();

	List<Experience> findBetween(int start, int end);
}
