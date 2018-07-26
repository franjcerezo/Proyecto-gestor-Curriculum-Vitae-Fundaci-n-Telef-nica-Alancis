package com.selectcv.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country_list", schema = "aaa")
public class CountryList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private int id;

	@OneToMany(mappedBy = "country")
	private Set<Education> education;

	@OneToMany(mappedBy = "country")
	private Set<JobOffer> jobOffer;

	@Column(name = "country")
	private String country;

	public CountryList() {
		// TODO Auto-generated constructor stub
	}

	public CountryList(int id, Set<Education> education, Set<JobOffer> jobOffer, String country) {
		super();
		this.id = id;
		this.education = education;
		this.jobOffer = jobOffer;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Education> getEducation() {
		return education;
	}

	public void setEducation(Set<Education> education) {
		this.education = education;
	}

	public Set<JobOffer> getJobOffer() {
		return jobOffer;
	}

	public void setJobOffer(Set<JobOffer> jobOffer) {
		this.jobOffer = jobOffer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + ((jobOffer == null) ? 0 : jobOffer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryList other = (CountryList) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id != other.id)
			return false;
		if (jobOffer == null) {
			if (other.jobOffer != null)
				return false;
		} else if (!jobOffer.equals(other.jobOffer))
			return false;
		return true;
	}

}
