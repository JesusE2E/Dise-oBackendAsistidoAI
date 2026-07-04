# Sistema de Procesamiento de Calificaciones con Spring Batch

## Descripción

Este proyecto consiste en el desarrollo de una aplicación backend en Java utilizando **Spring Boot**, **Spring Batch**, **Spring Data JPA**, **Spring Data MongoDB** y **Lombok** para automatizar el procesamiento de calificaciones de estudiantes.

El flujo principal de la aplicación realiza la lectura de un archivo CSV con información de estudiantes, procesa los datos para calcular el promedio de cada alumno y posteriormente genera un reporte con el estado académico (APROBADO o REPROBADO). Además, se expone una API REST que permite consultar y administrar la información procesada.

Como parte de la práctica también se utilizaron herramientas de asistencia basadas en Inteligencia Artificial para acelerar la generación de código, manteniendo siempre un proceso de revisión, validación y corrección manual antes de aceptar cualquier sugerencia.

---

# Objetivos de la práctica

- Implementar un proceso Batch utilizando Spring Batch.
- Leer información desde un archivo CSV.
- Procesar datos mediante la implementación de lógica de negocio.
- Persistir información en una base de datos relacional.
- Generar un segundo procesamiento para almacenar reportes en una base de datos NoSQL.
- Exponer los datos mediante una API REST.
- Implementar pruebas unitarias sobre la lógica de negocio.
- Aplicar buenas prácticas durante el desarrollo y la revisión del código generado.

---

# Arquitectura

El procesamiento está dividido en dos etapas:

## Paso 1

- Lectura del archivo `estudiantes.csv`.
- Cálculo del promedio de cada estudiante.
- Almacenamiento del resultado en una base de datos MySQL.

## Paso 2

- Lectura de los registros almacenados en MySQL.
- Determinación del estado académico:
  - APROBADO
  - REPROBADO
- Almacenamiento del reporte en MongoDB.

Posteriormente, una API REST permite consultar y administrar la información generada durante ambos procesos.

---

# Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Batch
- Spring Data JPA
- Spring Data MongoDB
- Maven
- MySQL
- MongoDB
- JUnit 5
- Mockito
- Git
- GitHub
- lombok

---

# Funcionalidades implementadas

## Procesamiento Batch

- Lectura de archivo CSV.
- Procesamiento mediante `ItemProcessor`.
- Escritura hacia MySQL.
- Segundo flujo Batch para generar reportes.
- Escritura hacia MongoDB.

## API REST

Se implementaron operaciones CRUD para consultar y administrar la información procesada.

Entre los endpoints disponibles se encuentran:

- Obtener todos los estudiantes.
- Obtener estudiante por identificador.
- Crear estudiante.
- Actualizar estudiante.
- Actualización parcial.
- Eliminar estudiante.
- Consultar cantidad de estudiantes aprobados.
- Consultar reportes por estado.

---

# Pruebas

El proyecto incluye pruebas unitarias para validar:

- El cálculo correcto del promedio.
- La asignación del estado académico.
- La lógica del servicio utilizando Mockito.

---

# Cómo ejecutar el proyecto

## Requisitos

- Java 21
- Maven
- Docker
- MySQL
- MongoDB

## Ejecutar la aplicación

```bash
mvn spring-boot:run
```

## Ejecutar las pruebas

```bash
mvn test
```

---

# Estructura del proyecto

```
src
├── main
│   ├── java
│   │   ├── batch
│   │   |    ├── config
│   │   |    ├── model
│   │   |    ├── processor
│   │   |    ├── rest
|   |   |         ├── model
│   │   |         ├── service
│   │   !         ├── repository
│   │   |         ├── view
│   │   └── SpringBatchApplication
│   └── resources
│       ├── application.properties
│       └── estudiantes.csv
└── test
    └── java
```

---

# Alcance de la práctica

El objetivo principal de esta práctica fue desarrollar un backend completo que integrara procesamiento Batch, persistencia en bases de datos relacionales y NoSQL, desarrollo de servicios REST y pruebas unitarias.

Durante el desarrollo se empleó una herramienta de asistencia basada en Inteligencia Artificial para apoyar la generación de código repetitivo y acelerar ciertas tareas. Sin embargo, todas las sugerencias fueron revisadas, validadas y, cuando fue necesario, corregidas manualmente para asegurar que la solución cumpliera con los requisitos funcionales y las buenas prácticas de desarrollo.

El alcance de la práctica se centró en comprender el funcionamiento del ecosistema Spring, la automatización de procesos Batch, el acceso a datos mediante JPA y MongoDB, la exposición de servicios REST y la aplicación de pruebas unitarias, reforzando además la importancia de la revisión crítica del código generado por herramientas asistidas por IA.

---

# Aprendizajes obtenidos

Durante el desarrollo del proyecto se fortalecieron conocimientos relacionados con:

- Spring Batch.
- Configuración de Jobs y Steps.
- Procesamiento masivo de información.
- Integración entre múltiples bases de datos.
- Desarrollo de APIs REST.
- Persistencia con Spring Data JPA y MongoDB.
- Pruebas unitarias con JUnit y Mockito.
- Uso responsable de herramientas de asistencia por Inteligencia Artificial dentro del proceso de desarrollo.

---
