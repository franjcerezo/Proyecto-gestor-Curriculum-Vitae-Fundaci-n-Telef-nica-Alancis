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

@Entity
@Table(name = "education", schema = "aaa")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_education", unique = true)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "country", nullable = false)
	private CountryList country;

	@Column(name = "education")
	private String education;

	@Column(name = "study_centre")
	private String studyCentre;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "city")
	private String city;

	@Column(name = "eqf_mec_level")
	private String eqfMecLevel;

	@Column(name = "description")
	private String description;

	public Education() {
		super();
	}

	public Education(int id, User user, CountryList country, String education, String studyCentre, Date startDate,
			Date endDate, String city, String eqfMecLevel, String description) {
		super();
		this.id = id;
		this.user = user;
		this.country = country;
		this.education = education;
		this.studyCentre = studyCentre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.eqfMecLevel = eqfMecLevel;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getStudyCentre() {
		return studyCentre;
	}

	public void setStudyCentre(String studyCentre) {
		this.studyCentre = studyCentre;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEqfMecLevel() {
		return eqfMecLevel;
	}

	public void setEqfMecLevel(String eqfMecLevel) {
		this.eqfMecLevel = eqfMecLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((eqfMecLevel == null) ? 0 : eqfMecLevel.hashCode());
		result = prime * result + id;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((studyCentre == null) ? 0 : studyCentre.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Education other = (Education) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		if (eqfMecLevel == null) {
			if (other.eqfMecLevel != null)
				return false;
		} else if (!eqfMecLevel.equals(other.eqfMecLevel))
			return false;
		if (id != other.id)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (studyCentre == null) {
			if (other.studyCentre != null)
				return false;
		} else if (!studyCentre.equals(other.studyCentre))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
