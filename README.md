# Codo a Codo Java Fullstack 

Proyecto final julio 2024

---


 <div align="center">
  
<!-- PROJECT SHIELDS -->
[![JSBadge][JS-shield]][JS-url]
[![JavaBadge][Java-shield]][Java-url]
[![SpringbootBadge][Springboot-shield]][Springboot-url]
[![HibernateBadge][Hibernate-shield]][Hibernate-url]
[![MySQLBadge][MySQL-shield]][MySQL-url]
[![bootstrapBadge][bootstrap-shield]][bootstrap-url]
<!-- PROJECT SHIELDS -->
  
 </div>
 
La aplicacion utiliza la API TMDB para mostrar las series mas populares, ademas:

- Permite guardar una serie con su nombre, rating del usuario y una reseña
- Permite visualizar una lista con las series guardadas y modificar o borrar sus datos.

Es un proyecto CRUD local que utiliza el patrón MVC, desacoplando la interfaz de usuario (vista), los datos (modelo) y la lógica de la aplicación (controlador).

El front-end está desarrollado con HTML, CSS/Bootstrap y JavaScript, mientras que el back-end está construido con Java, utilizando el framework Spring Boot y MySQL como base de datos.

Se inicializa en http://localhost:8080/ y tiene los siguientes endpoints:

<br>Lista de Series:
<br>URL: /listSeries
<br>Método HTTP: GET
<br>Descripción: Obtiene una lista de todas las series.

<br>Agregar Serie:
<br>URL: /addSerie
<br>Método HTTP: POST
<br>Descripción: Añade una nueva serie.


<br>Eliminar Serie:
<br>URL: /delSerie/{id}
<br>Método HTTP: DELETE
<br>Descripción: Elimina una serie por su ID.

<br>Actualizar Serie:
<br>URL: /updateSerie/{id}
<br>Método HTTP: PUT
<br>Descripción: Actualiza los detalles de una serie existente por su ID.


---

---
 [**Demo- video**](https://youtu.be/C88N0Ozy9w0)

<!-- PROJECT SHIELDS VARIABLES-->
[Java-shield]:https://img.shields.io/badge/Back-Java-black?style=flat&labelColor=%23808080k&color=teal
[Java-url]:-
[bootstrap-shield]:https://img.shields.io/badge/CSS-Bootstrap-black?style=flat&labelColor=%23808080k&color=teal
[bootstrap-url]: -
[MySQL-shield]:https://img.shields.io/badge/DB-MySQL-black?style=flat&labelColor=%23808080k&color=teal
[MySQL-url]:-
[JS-shield]:https://img.shields.io/badge/Front-JS-red
[JS-url]:-
[Hibernate-shield]: https://img.shields.io/badge/ORM-Hibernate-black?style=flat&labelColor=%23808080k&color=teal
[Hibernate-url]: -
[Springboot-shield]:https://img.shields.io/badge/Framework-Springboot-black?style=flat&labelColor=%23808080k&color=teal
[Springboot-url]: -
