package com.selectcv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selectcv.model.JobOffer;
import com.selectcv.repository.JobOfferRepository;
import com.selectcv.service.JobOfferService;

@Service
@Transactional
public class JobOfferServiceImpl implements JobOfferService {

	@Autowired
	private JobOfferRepository jobOfferRepository;

	@Override
	public JobOffer save(JobOffer jobOffer) {
		return jobOfferRepository.save(jobOffer);
	}

	@Override
	public Boolean delete(int id) {
		if (jobOfferRepository.existsById(id)) {
			jobOfferRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public JobOffer update(JobOffer jobOffer) {
		return jobOfferRepository.save(jobOffer);
	}

	@Override
	public List<JobOffer> findByIdRecruiter(int id) {
		return jobOfferRepository.findByIdRecruiter(id);
	}

	@Override
	public JobOffer findById(int id) {
		return jobOfferRepository.findById(id);
	}

	@Override
	public List<JobOffer> findAll() {
		return (List<JobOffer>) jobOfferRepository.findAll();
	}

}
