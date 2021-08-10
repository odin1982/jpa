package org.jpa.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.jpa.enums.CustomerStatus;

//APUNTES - @Entity - Declara la clase como una entidad
//APUNTES - @Table 	- Indica la tabla con la cual se va a mapear
//APUNTES - @Id 	- Indica que este atributo sera la llave primaria
//APUNTES - @GeneratedValue(strategy=GenerationType.IDENTITY) - Le indica la forma en que va a autoincrementar tu llave primaria

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name",length = 30,nullable = false)
	private String firstname;
	
	@Column(name="last_name", length = 50)
	private String lastname;
	
	@Column(name="birthDate", nullable = false)
	private LocalDate birthdate;
	
	@Column(name="fecha_registro",nullable = false, updatable = false)
	private LocalDateTime regDate;
		
	@Enumerated(EnumType.STRING)
	@Column(name="status",nullable=false)
	private CustomerStatus status;
	
	@Transient
	private String fullName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
		this.setFullName(firstname + " " + lastname);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
		this.setFullName(firstname + " " + lastname);
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", regDate=" + regDate + ", status=" + status + ", fullName=" + fullName + "]";
	}

}
