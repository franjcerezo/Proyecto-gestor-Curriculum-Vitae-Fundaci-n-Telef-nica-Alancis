package com.selectcv.service;

import java.util.List;

import com.selectcv.model.Education;
import com.selectcv.model.User;


public interface EducationService {
	
	Education save(Education education);

    Boolean delete(int id);

    Education update(Education education);
    
    Education findById(int id);

    List<Education> findByUser(User user);

    List<Education> findAll();
    
    

//    List<Education> findByStatus(String status);
//
//    List<Education> findByUserIdStatus(int userId, String status);

    List<Education> findBetween(int start, int end);

}
