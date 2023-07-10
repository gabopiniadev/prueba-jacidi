package com.develop.backend.Model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "clients", schema = "db_jacidi")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "dni")
    private String dni;
    
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "lastdelivery")
    private Date lastdelivery;

    @Column(name = "nextrenewal")
    private Date nextrenewal;
    
    @Column(name = "membership")
    @JoinColumn(name = "key")
    private String membership;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getLastdelivery() {
		return lastdelivery;
	}

	public void setLastdelivery(Date lastdelivery) {
		this.lastdelivery = lastdelivery;
	}

	public Date getNextrenewal() {
		return nextrenewal;
	}

	public void setNextrenewal(Date nextrenewal) {
		this.nextrenewal = nextrenewal;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}
	
	
    

}