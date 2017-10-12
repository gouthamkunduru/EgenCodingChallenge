package com.egen.usermanagement.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Implemented During Egen coding Challenge 
 * Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
@Entity
@Table(name = "USER")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	//UUID implementation1
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column
	private String middleName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false, length = 3)
	private int age;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false, length = 10)
	private long phone;
	@Column
	private String zip;

	public Users() {
	}

	public Users(UUID id, String firstName, String middleName, String lastName, int age, String gender, long phone,
			String zip) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.zip = zip;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}