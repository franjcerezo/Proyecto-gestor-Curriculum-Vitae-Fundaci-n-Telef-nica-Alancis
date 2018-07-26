package com.selectcv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.selectcv.model.Education;
import com.selectcv.model.User;

public interface EducationRepository extends CrudRepository<Education, Integer> {

	List<Education> findByUser(User user);

	Education findById(int id);


	@Query("from Education t where t.id BETWEEN  :start and :end")
	List<Education> findBetween(@Param("start") int start, @Param("end") int end);
}
