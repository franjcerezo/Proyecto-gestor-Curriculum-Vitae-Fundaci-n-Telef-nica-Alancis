package com.selectcv.service;

import java.util.List;

import com.selectcv.model.JobOffer;


public interface JobOfferService {
	
	JobOffer save(JobOffer jobOffer);

    Boolean delete(int id);

    JobOffer update(JobOffer jobOffer);
    
    List<JobOffer> findByIdRecruiter(int id);
    
    JobOffer findById(int id);


    List<JobOffer> findAll();

}
