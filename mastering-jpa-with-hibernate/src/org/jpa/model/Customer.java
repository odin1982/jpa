package org.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="first_name",length = 30,nullable = false,updatable = false,unique=true)
	private String firstname;
	
	@Column(name="last_name", length = 50)
	private String lastname;
	
	//precision cuantos numeros contando decimales debe de haber, scale= cuantos decimales va a tener
	//ejemplo= 123456.7890
	@Column(name="number", precision=10, scale=4)
	private BigDecimal number;
	
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
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
