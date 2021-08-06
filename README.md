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

#### transaction-type
    Como queremos gestionar las transacciones.
    - JTA: El servidor de aplicaciones se encarga de administrar las transacciones.
    - RESOURCE_LOCAL: Nosotros nos encargamos de abrir o cerrar las transacciones.

    <persistence-unit name="mastering-jpa-with-hibernate" transaction-type="RESOURCE_LOCAL">
		<class>org.jpa.model.Customer</class>
		<properties>
            <!-- driver de la base de datos que estamos usando -->
			<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
			<!-- usuario de la BD-->
            <property name="javax.persistence.jdbc.user" value="root"/>
			<!-- contraseña de la BD -->
            <property name="javax.persistence.jdbc.password" value="barcelona8"/>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/orderapi?serverTimezone=UTC"/>
             <!-- dialecto: como hibernate convierte los objetos en SQL nativo-->
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
			<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
            <!-- Nos indica si queremos ver las instrucciones de SQL que se van ejecutando -->
            <property name="hibernate.show_sql" value="true"/>
		</properties>
	</persistence-unit> 

## PATRON FACTORY
    Crear clases sin conocer la implementación exacta.

## AVANCE
Persistir una entidad

## INSTRUCCIONES BD
CREATE SCHEMA `orderapi` ;

