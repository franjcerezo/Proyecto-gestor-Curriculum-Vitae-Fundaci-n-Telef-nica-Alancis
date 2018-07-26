package com.selectcv.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "job_offer", schema = "aaa")
public class JobOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idoffer", unique = true)
	private int id;

//	 @OneToMany(mappedBy="jobOffer")
//	    private Set<Registration> registration;

	@Column(name = "job")
	private String job;

	@Column(name = "company")
	private String company;

	@Column(name = "description")
	private String description;

	@Column(name = "city")
	private String city;

	@ManyToOne
	@JoinColumn(name = "country")
	private CountryList country;

	@Column(name = "education")
	private String education;

	@Column(name = "skills")
	private String skills;

	@Column(name = "languages")
	private String languages;

	@Column(name = "work_experience")
	private String workExperience;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private java.util.Date creationDate;

	@Column(name = "publication_date")
	private Date publicationDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "comments")
	private String comments;

	@Column(name = "offer_status")
	private String offerStatus;

	@Column(name = "id_recruiter")
	private Integer idRecruiter;

	public JobOffer() {
		// TODO Auto-generated constructor stub
	}

	public JobOffer(int id, String job, String company, String description, String city, CountryList country,
			String education, String skills, String languages, String workExperience, java.util.Date creationDate,
			Date publicationDate, Date endDate, String comments, String offerStatus, Integer idRecruiter) {
		super();
		this.id = id;

		this.job = job;
		this.company = company;
		this.description = description;
		this.city = city;
		this.country = country;
		this.education = education;
		this.skills = skills;
		this.languages = languages;
		this.workExperience = workExperience;
		this.creationDate = creationDate;
		this.publicationDate = publicationDate;
		this.endDate = endDate;
		this.comments = comments;
		this.offerStatus = offerStatus;
		this.idRecruiter = idRecruiter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CountryList getCountry() {
		return country;
	}

	public void setCountry(CountryList country) {
		this.country = country;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public java.util.Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Integer getIdRecruiter() {
		return idRecruiter;
	}

	public void setIdRecruiter(Integer idRecruiter) {
		this.idRecruiter = idRecruiter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((idRecruiter == null) ? 0 : idRecruiter.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((offerStatus == null) ? 0 : offerStatus.hashCode());
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());

		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((workExperience == null) ? 0 : workExperience.hashCode());
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
		JobOffer other = (JobOffer) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (idRecruiter == null) {
			if (other.idRecruiter != null)
				return false;
		} else if (!idRecruiter.equals(other.idRecruiter))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (offerStatus == null) {
			if (other.offerStatus != null)
				return false;
		} else if (!offerStatus.equals(other.offerStatus))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;

		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (workExperience == null) {
			if (other.workExperience != null)
				return false;
		} else if (!workExperience.equals(other.workExperience))
			return false;
		return true;
	}

}
