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
//ORACLE 11g
//@SequenceGenerator(name="customer_sec",sequenceName = "customer_sec",initialValue = 1,allocationSize = 1)
public class Customer {
	
	//ORACLE 11g
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator ="customer_sec" )
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name",length = 30,nullable = false)
	private String firstname;
	
	@Column(name="last_name", length = 50)
	private String lastname;
	
	//APUNTES - Calendar - Como Calendar graba fecha y hora hay que especificar que necesitamos y eso lo hacemos con @Temporal
	//APUNTES - @Temporal - Existen 3 tipos DATE,TIME,TIMESTAMP
	@Temporal(TemporalType.DATE)
	@Column(name="birthDate", nullable = false)
	private Calendar birthdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro",nullable = false, updatable = false)
	private Calendar regDate;
	
	//Another way to insert a date value without setting the Object
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro_another_way",nullable = false, updatable = false)
	private Calendar regDateAnotherWay= Calendar.getInstance();
	
	//Using LocalDate Java 8
	@Column(name="fecha_registro_localdate",nullable = false, updatable = false)
	private LocalDate regDateLocalDate;
	
	//Another way to insert a date value without setting the Object
	@Column(name="fecha_registro_another_way_localdate",nullable = false, updatable = false)
	private LocalDateTime regDateAnotherWayLocalDate = LocalDateTime.now();
	
	//APUNTES-Existen dos formas de declarar un enum en JPA con @Enumerated
	//APUNTES-EnumType.ORDINAL [Graba la posicion del enum]
	//APUNTES-EnumType.STRING [Graba la cadena del enum]
	//[Se recomienda usar STRING,ya que con ORDINAL si agregan un nuevo enum arriba de los ya exitentes, los valores ya no seran los mismo, la integridad se rompe]
	//@Enumerated(EnumType.ORDINAL)
	
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
	
	public Calendar getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}
	
	public Calendar getRegDate() {
		return regDate;
	}
	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}
	
	public Calendar getRegDateAnotherWay() {
		return regDateAnotherWay;
	}
	
	public void setRegDateAnotherWay(Calendar regDateAnotherWay) {
		this.regDateAnotherWay = regDateAnotherWay;
	}
	
	public LocalDate getRegDateLocalDate() {
		return regDateLocalDate;
	}
	
	public void setRegDateLocalDate(LocalDate regDateLocalDate) {
		this.regDateLocalDate = regDateLocalDate;
	}
	
	public LocalDateTime getRegDateAnotherWayLocalDate() {
		return regDateAnotherWayLocalDate;
	}
	
	public void setRegDateAnotherWayLocalDate(LocalDateTime regDateAnotherWayLocalDate) {
		this.regDateAnotherWayLocalDate = regDateAnotherWayLocalDate;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", regDate=" + regDate + ", regDateAnotherWay=" + regDateAnotherWay + ", regDateLocalDate="
				+ regDateLocalDate + ", regDateAnotherWayLocalDate=" + regDateAnotherWayLocalDate + ", status=" + status
				+ "]";
	}
	
	
}
