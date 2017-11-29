# Repositorio-disenio-2017







# Pasos para levantar el servidor:
 
 1) Crear un schema en Mysql -> dds_utn  
     - Usuario y contraseña deben estar en application.properties
 2) Ejecutar Application.class
     - Utilizando maven el comando es mvn spring-boot:run
 3) Ejecutar el archivo carga_datos_dds.sql (Puede hacerse sin apagar el servidor)
 
 Versiones:
 - mysql  Ver 14.14 Distrib 5.7.20
 - Apache Maven 3.3.9


# CSV de Cuentas

- Los csv de cuenta deben estar separados por ,
- Los campos necesarios para cargar una nueva cuenta:

  'cuenta_id', 'tipo_cuenta', 'fecha_inicio', 'fecha_fin', 'roi', 'gross_booking', 'profit', 'cost'
 


# Tecnologías usadas

- Spring
- Spring Boot (https://projects.spring.io/spring-boot/)
- Spring JPA  (https://projects.spring.io/spring-data-jpa/)
- Spring Batch 
- MySQL
- Antlr
- Drools
