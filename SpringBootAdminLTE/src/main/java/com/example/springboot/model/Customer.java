package com.example.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/** Generated serial version UID */
	private static final long serialVersionUID = -4849928054866763730L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname", nullable = false, length = 60)
	private String firstname;

	@Column(name = "lastname", nullable = false, length = 60)
	private String lastname;

	@Column(name = "email", nullable = false, length = 60, unique = true)
	private String email;

	@Column(name = "added_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date addedDate;

	/** Default constructor. */
	public Customer() {
		id = 0L;
		firstname = null;
		lastname = null;
		email = null;
		addedDate = null;
	}

	// ---- toString, hashCode, equals, compareTo ----

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this).append("id", id).append("firstname", firstname)
				.append("lastname", lastname).append("email", email);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder().append(firstname).append(lastname).append(email);
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object pObject) {
		if (this == pObject) {
			return true;
		}
		if (pObject == null) {
			return false;
		}
		if (pObject instanceof Customer) {
			Customer bean = (Customer) pObject;
			EqualsBuilder builder = new EqualsBuilder().append(firstname, bean.firstname)
					.append(lastname, bean.lastname).append(email, bean.email);
			return builder.isEquals();
		} else {
			return false;
		}
	}

	// ---- Getter and Setter ----

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAddedDate() {
		return addedDate;
	}
}
