package com.selectcv.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.selectcv.model.JobOffer;

public interface JobOfferRepository extends CrudRepository<JobOffer, Integer> {

	List<JobOffer> findByIdRecruiter(int id);

	JobOffer findById(int id);
}
