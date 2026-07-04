<div align="center">

# **lISTA DE PROMTS PARA EL DISEÑO DE UN BACKEND CON SPRING-BOOT**

</div>

---

## **1.- Promt de creacion del archivo de configuracion pom.xml**

> **Al archivo actual pom.xml agrega Spring Boot 3.2.2 con Java > 21 y estas dependencias:
> spring-boot-starter-batch, mysql-connector-j (scope runtime), > spring-boot-starter-data-mongodb, spring
> boot-starter-web, spring-boot-starter-data-jpa y
> spring-boot-starter-test (scope test). 
> agrega la dependencia de lombok con un scope igual a compile para podel manejar en este caso solo los logs
>groupId
>com.academia, artifactId spring-batch-final-calificaciones, 
>versión 1.0.0. Incluye el spring-boot-maven
> plugin**


---

## **2.- Promt de creacion de un documento (objeto de dominio)**

>**crea una clase que servira para mapear a un documento para una base de datos no sql, el nombre de la clase debe ser EstudianteReporte y debe contener las siguientes caracteristicas Documento de MongoDB (@Document collection = "reportes_estudiantes") con:
>id (String, anotado con @Id), nombre, grupo, promedio (double) y estado (String).
>Constructor vacio, getters, setters y toString.. para este caso no uses anotaciones de lombok es**

---

## **3.- Promt de creacion ReporteEstudianteProcessor**

> **Necesito que la clase ReporteEstudianteProcessor que se encuentra dentro del proyecto implemente >ItemProcessor<Estudiante, EstudianteReporte>.
>dentro de la logica de procesamiento es necesario que se haga >la conversion de Estudiante en un EstudianteReporte copiando >nombre, grupo y promedio,
>y asigna estado "APROBADO" si el promedio es >= 70, o >"REPROBADO" si es menor.
>quiero que el metodo tenga el siguiente log el cual re registre >al finalizar el metodo  "Step 2 - Reporte: {reporte}" y >devuelve el reporte. quiero que el log tenga el nivel info y se >tome de lombok para lo cual agrega la anotacion @Slf4j en la >clase **




---


---

## **3.- Promt de creacion Clase Configuration**

> **`Actúa como un desarrollador Senior experto en Spring Boot 3 y Spring Batch 5.

>Tu única tarea es generar el archivo **BatchConfig.java**.

>Debes generar exactamente una clase de configuración de Spring Batch con las >siguientes características:

>* Debe estar anotada con `@Configuration`.
>* Debe llamarse `BatchConfig`.
>* Debe declarar todos los Beans necesarios.
>* No agregues comentarios.
>* No agregues explicaciones.
>* No agregues texto antes ni después del código.
>* Devuelve únicamente código Java válido.

>La clase debe contener exactamente estos Beans y en este mismo orden:

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

No inventes clases adicionales.

No cambies los nombres de métodos.

No cambies los nombres de variables.

No optimices el código.

No modifiques el SQL.

No agregues nuevas funcionalidades.

La salida debe ser únicamente el contenido completo de `BatchConfig.java`.
`**

---














## **.- Promt de creacion del contenido del archivo .gitignore**

>**Con base es la estructura actual del proyecto ingresa la lista completa de elementos dentro del archivo .gitignore de tal manera que solo se suba al repositorio los archivos necesarios para el correcto funcionamiento de la aplicacion de esta manera evitar subir archivos inecesarios al repositorio remoto **

---