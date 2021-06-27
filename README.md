# jpa
## QUE ES JPA?
    - Java Persistence API
    - Propuesta de java para persistir datos
    - ORM(Object Relational Mapping)
    - Puente entre objetos y base de datos
   
## PERSISTENCE.XML
	- Corazon aplicacion jpa,configura las conexiones

## ANOTACIONES
@Entity - Declara la clase como una entidad
@Table 	- Indica la tabla con la cual se va a mapear
@Id 	- Indica que este atributo sera la llave primaria
@GeneratedValue(strategy=GenerationType.IDENTITY) - Le indica la forma en que va a autoincrementar tu llave primaria

## INSTRUCCIONES BD
CREATE SCHEMA `orderapi` ;

