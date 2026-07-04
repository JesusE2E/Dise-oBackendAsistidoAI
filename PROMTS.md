<div align="center">

# **lISTA DE PROMTS PARA EL DISEÑO DE UN BACKEND CON SPRING-BOOT**

</div>

---

## **1.- Promt de creacion del archivo de configuracion pom.xml**

Actúa como un arquitecto Senior especializado en Java 21, Maven y Spring Boot 3.

Tu única tarea es generar el archivo **pom.xml** de un proyecto Maven.

## Reglas obligatorias

- Devuelve únicamente el contenido completo del archivo `pom.xml`.
- No agregues comentarios.
- No agregues explicaciones.
- No agregues texto antes ni después del XML.
- El XML debe ser válido y listo para copiar y pegar.

## Especificaciones del proyecto

El proyecto debe cumplir exactamente con las siguientes especificaciones:

- **modelVersion:** `4.0.0`
- **Parent:**
  - `groupId`: `org.springframework.boot`
  - `artifactId`: `spring-boot-starter-parent`
  - `version`: `3.2.2`
  - `relativePath` vacío
- **groupId:** `com.academia`
- **artifactId:** `spring-batch-final-calificaciones`
- **version:** `1.0.0`
- **Java:** `21`

## Dependencias obligatorias

Incluye exactamente estas dependencias y únicamente estas:

1. `org.springframework.boot:spring-boot-starter-batch`

2. `com.mysql:mysql-connector-j`
   - `scope`: `runtime`

3. `org.springframework.boot:spring-boot-starter-data-mongodb`

4. `org.springframework.boot:spring-boot-starter-web`

5. `org.springframework.boot:spring-boot-starter-data-jpa`

6. `org.springframework.boot:spring-boot-starter-test`
   - `scope`: `test`

7. `org.projectlombok:lombok`
   - `version`: `1.18.46`
   - `scope`: `compile`

## Build

En la sección `<build>` incluye únicamente el plugin:

- `org.springframework.boot:spring-boot-maven-plugin`

## Orden obligatorio

Respeta exactamente este orden:

1. `modelVersion`
2. `parent`
3. `groupId`
4. `artifactId`
5. `version`
6. `properties`
7. `dependencies`
8. `build`



## Formato de salida

La salida debe ser **únicamente** el contenido completo del archivo `pom.xml`, sin texto adicional.

---

## **2.- Promt de creacion de un documento (objeto de dominio)**
# Prompt para generar la clase `EstudianteReporte.java`

Actúa como un desarrollador Senior especializado en Java 21, Spring Boot 3 y Spring Data MongoDB.

Tu única tarea es generar el archivo **EstudianteReporte.java**.

## Reglas obligatorias

- Devuelve únicamente el código Java.
- No agregues comentarios.
- No agregues explicaciones.
- No agregues texto antes ni después del código.
- El código debe compilar correctamente.
- No utilices Lombok.
- Implementa manualmente todos los constructores, getters, setters y el método `toString()`.

## Especificaciones de la clase

La clase debe pertenecer exactamente al siguiente paquete:

```java
package com.academia.batch.model;
```

Debe importar únicamente las siguientes clases:

```java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
```

La clase debe llamarse:

```java
EstudianteReporte
```

Debe estar anotada exactamente con:

```java
@Document(collection = "reportes_estudiantes")
```

## Atributos

Declara exactamente los siguientes atributos y en este mismo orden:

```java
@Id
private String id;

private String nombre;

private String grupo;

private double promedio;

private String estado;
```

## Constructor

Genera únicamente un constructor vacío:


No agregues constructores adicionales.

## Métodos

Implementa manualmente los siguientes métodos:

- `getId()`
- `setId(String id)`
- `getNombre()`
- `setNombre(String nombre)`
- `getGrupo()`
- `setGrupo(String grupo)`
- `getPromedio()`
- `setPromedio(double promedio)`
- `getEstado()`
- `setEstado(String estado)`

Todos deben seguir la convención estándar de JavaBeans.

## Método toString()

Sobrescribe el método `toString()` utilizando la anotación:

```java
@Override
```



## Restricciones

- No utilices Lombok.
- No utilices Records.
- No utilices anotaciones adicionales.
- No agregues métodos `equals()` ni `hashCode()`.
- No agregues lógica adicional.
- No agregues validaciones.
- No agregues comentarios.
- No cambies los nombres de los atributos.


## Formato de salida

La salida debe ser **únicamente** el contenido completo del archivo `EstudianteReporte.java`, listo para copiar y pegar.
---

## **3.- Promt de creacion ReporteEstudianteProcessor**

> **Necesito que la clase ReporteEstudianteProcessor que se encuentra dentro del proyecto implemente >ItemProcessor<Estudiante, EstudianteReporte>.
>dentro de la logica de procesamiento es necesario que se haga >la conversion de Estudiante en un EstudianteReporte copiando >nombre, grupo y promedio,
>y asigna estado "APROBADO" si el promedio es >= 70, o >"REPROBADO" si es menor.
>quiero que el metodo tenga el siguiente log el cual re registre >al finalizar el metodo  "Step 2 - Reporte: {reporte}" y >devuelve el reporte. quiero que el log tenga el nivel info y se >tome de lombok para lo cual agrega la anotacion @Slf4j en la >clase **




---


---

## **3.- Promt de creacion Clase Configuration**

 **`Actúa como un desarrollador Senior experto en Spring Boot 3 y Spring Batch 5.

Tu única tarea es generar el archivo **BatchConfig.java**.

Debes generar exactamente una clase de configuración de Spring Batch con las siguientes características:

* Debe estar anotada con `@Configuration`.
* Debe llamarse `BatchConfig`.
* Debe declarar todos los Beans necesarios.
* No agregues comentarios.
* No agregues explicaciones.
* No agregues texto antes ni después del código.
* Devuelve únicamente código Java válido.

La clase debe contener exactamente estos Beans y en este mismo orden:

>1. `PlatformTransactionManager transactionManager(DataSource dataSource)` >utilizando `DataSourceTransactionManager`.

2. `FlatFileItemReader<Estudiante> readerEstudiantes()` anotado con `@StepScope` que:

   * lea `estudiantes.csv`
   * ignore la primera línea
   * use delimitador ","
   * tenga los campos:

     * nombre
     * grupo
     * nota1
     * nota2
     * nota3
   * use `targetType(Estudiante.class)`.

3. `EstudianteProcesor estudianteProcessor()`.

4. `JdbcBatchItemWriter<Estudiante> writerEstudiantes(DataSource dataSource)` que inserte en la tabla `estudiantes_procesados` los campos:

   * nombre
   * grupo
   * nota1
   * nota2
   * nota3
   * promedio

5. `Step paso1(...)` usando:

   * JobRepository
   * PlatformTransactionManager
   * readerEstudiantes
   * estudianteProcessor
   * writerEstudiantes
   * chunk(3)

6. `JdbcCursorItemReader<Estudiante> readerReporteDesdeMysql(DataSource dataSource)` que ejecute:

```sql
SELECT nombre, grupo, promedio FROM estudiantes_procesados
```

usando `BeanPropertyRowMapper<>(Estudiante.class)`.

7. `ReporteEstudianteProcessor reporteEstudianteProcessor()`.

8. `MongoItemWriter<EstudianteReporte> writerReportesMongo(MongoTemplate mongoTemplate)` utilizando la colección:

```text
reportes_estudiantes
```

9. `Step paso2(...)` usando:

   * readerReporteDesdeMysql
   * reporteEstudianteProcessor
   * writerReportesMongo
   * chunk(3)

10. `Job procesarCalificacionesJob(...)` que:

* use `RunIdIncrementer`
* empiece con `paso1`
* continúe con `paso2`

Usa exactamente las clases:

* FlatFileItemReaderBuilder
* JdbcBatchItemWriterBuilder
* JdbcCursorItemReaderBuilder
* MongoItemWriterBuilder
* StepBuilder
* JobBuilder
* RunIdIncrementer
* BeanPropertyItemSqlParameterSourceProvider
* BeanPropertyRowMapper
* ClassPathResource



La salida debe ser únicamente el contenido completo de `BatchConfig.java`.
`**

---




# Prompt para la clase principal

Actúa como un desarrollador Senior especializado en Java 21 y Spring Boot 3.

Genera únicamente el archivo `SpringBatchApplication.java`.

Requisitos:

- La clase debe llamarse `SpringBatchApplication`.
- Debe estar anotada con `@SpringBootApplication`.
- Debe importar únicamente:
  - `org.springframework.boot.SpringApplication`
  - `org.springframework.boot.autoconfigure.SpringBootApplication`
- Debe contener únicamente el método:

```java
public static void main(String[] args)
```

- Dentro del método debe ejecutarse exactamente:

```java
SpringApplication.run(SpringBatchApplication.class, args);
```

No agregues comentarios, explicaciones, atributos, constructores, métodos adicionales ni texto fuera del código. Devuelve únicamente el contenido completo del archivo `SpringBatchApplication.java`.









## **.- Promt de creacion del contenido del archivo .gitignore**

>**Con base es la estructura actual del proyecto ingresa la lista completa de elementos dentro del archivo .gitignore de tal manera que solo se suba al repositorio los archivos necesarios para el correcto funcionamiento de la aplicacion de esta manera evitar subir archivos inecesarios al repositorio remoto **

---