package com.selectcv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.selectcv.model.Experience;
import com.selectcv.model.User;

public interface ExperienceRepository extends CrudRepository<Experience, Integer> {

	List<Experience> findByUser(User user);

	Experience findById(int id);

	@Query("from Experience e where e.id BETWEEN  :start and :end")
	List<Experience> findBetween(@Param("start") int start, @Param("end") int end);
}
