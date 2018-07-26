package com.selectcv.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "registration", schema = "aaa")
public class Registration implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_offer")
	private int idOffer;

	@Column(name = "id_user")
	private int idUser;

	@Column(name = "cv_status")
	private String cvStatus;

//	 @ManyToOne
//	    @JoinColumn(name="id_user")
//	    private User user;
//	
//	 @ManyToOne
//	    @JoinColumn(name="id_offer")
//	    private JobOffer jobOffer;

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(int idOffer, int idUser, String cvStatus) {
		super();
		this.idOffer = idOffer;
		this.idUser = idUser;
		this.cvStatus = cvStatus;

	}

	public int getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCvStatus() {
		return cvStatus;
	}

	public void setCvStatus(String cvStatus) {
		this.cvStatus = cvStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvStatus == null) ? 0 : cvStatus.hashCode());
		result = prime * result + idOffer;
		result = prime * result + idUser;

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
		Registration other = (Registration) obj;
		if (cvStatus == null) {
			if (other.cvStatus != null)
				return false;
		} else if (!cvStatus.equals(other.cvStatus))
			return false;

		return true;
	}

}
