# jpa
## QUE ES JPA?
    - Java Persistence API
    - Propuesta de java para persistir datos
    - ORM(Object Relational Mapping)
    - Puente entre objetos y base de datos
   
## PERSISTENCE.XML
	- Corazon aplicacion jpa,configura las conexiones

## ANOTACIONES
- @Entity - Declara la clase como una entidad
- @Table 	- Indica la tabla con la cual se va a mapear
- @Id 	- Indica que este atributo sera la llave primaria
- @GeneratedValue(strategy=GenerationType.IDENTITY) - Le indica la forma en que va a autoincrementar tu llave primaria
- @Temporal - We use this annotation  when we use Date or Calendar with version lowers than Java 8.
- @Enumerated - Persist enums
- @Transient - Unidades que no deben ser persistidas en la BD

## Serializable
    Es cuando un objeto viaje a traves de la red se convierte en 0 y 1's y del otro lado se vuelve a deserializar

## Persistence.xml
    - realizamos configuraciones para conectarnos a la BD
    - Es leido por JPA de forma predeterminada en la carpeta META-INF

### Persistence Unit
    Es donde configuramos como JPA se va a conectar a una base de datos.
    Administra coneccion , entidades, cache, como es creado el esquema.

## INSTRUCCIONES BD
CREATE SCHEMA `orderapi` ;

