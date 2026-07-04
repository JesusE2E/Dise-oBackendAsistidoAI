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



--
# Prompt

Genera únicamente el archivo `application.properties` para un proyecto Spring Boot 3.

## Configuración de base de datos MySQL

- URL: `jdbc:mysql://localhost:3306/academia`
- Usuario: `alumno`
- Contraseña: `alumno123`

Incluye configuraciones compatibles con Spring Data JPA y Hibernate.

## Configuración de Spring Batch

- Inicializar el esquema de Spring Batch en cada arranque.
- Permitir configuración para controlar el comportamiento de inicialización del esquema con opciones como:
  - `always`
  - `none`

- Ejecutar automáticamente el Job al iniciar la aplicación.

## Configuración MongoDB (Docker)

- URI:
  `mongodb://root:root123@localhost:27017/academia?authSource=admin`

## Logging

- Configura logs en un formato legible y agradable.
- Incluye soporte para colores en consola si es posible.
- Ajusta el nivel de logging para facilitar depuración.

## Requisitos adicionales

- Incluye propiedades para control de inicialización de base de datos (crear o no crear esquema al iniciar la aplicación).
- Permite alternar entre modos como `none` y `always` en dichas configuraciones.

## Restricciones

- Utiliza únicamente propiedades compatibles con Spring Boot 3.
- No agregues comentarios.
- No agregues explicaciones.
- No agregues texto antes ni después del archivo.
- Devuelve únicamente el contenido completo del archivo `application.properties`.



--

--
# Prompt para la estructura de capas y clases en Servicios REST

Actúa como un arquitecto Senior experto en Java 21, Spring Boot 3, JPA y arquitectura en capas (Controller, Service, Repository, Model, View).

Tu tarea es generar la estructura de paquetes y clases dentro del paquete:

```
com.academia.batch.rest
```

---

## 📦 Estructura de paquetes

Dentro de `rest` debes crear los siguientes subpaquetes:

- model
- repository
- service
- view

---

## 🧩 Paquete `model`

Crea la clase:

```
EstudianteEntity
```

### Requisitos:

- Debe mapear la tabla `estudiantes_procesados`
- Usar anotaciones JPA:
  - `@Entity`
  - `@Table(name = "estudiantes_procesados")`
- Campos:

| Campo | Tipo DB | Tipo Java |
|------|--------|----------|
| id | INT AUTO_INCREMENT | Long |
| nombre | VARCHAR(100) | String |
| grupo | VARCHAR(10) | String |
| nota1 | DECIMAL(5,2) | Long |
| nota2 | DECIMAL(5,2) | Long |
| nota3 | DECIMAL(5,2) | Long |
| promedio | DECIMAL(5,2) | Long |

### Reglas:

- `id` debe tener:
  - `@Id`
  - `@GeneratedValue(strategy = GenerationType.IDENTITY)`

---

## 🗄️ Paquete `repository`

Crear dos interfaces:

### 1. `EstudianteRepository`

- Extiende:
```
JpaRepository<EstudianteEntity, Long>
```

- Método adicional:

```java
List<EstudianteEntity> findByGrupo(String grupo);
```

---

### 2. `ReporteRepository`

- Extiende:
```
JpaRepository<EstudianteReporte, Long>
```

- Método adicional:

```java
List<EstudianteReporte> findByEstado(String estado);
```

---

## ⚙️ Paquete `service`

Crear la clase:

```
EstudianteService
```

### Requisitos:

- Anotar con:
```
@Service
```

- Inyectar `EstudianteRepository` usando **inyección por constructor**

---

### Método requerido:

```java
Long contarAprobados();
```

### Lógica del método:

- Usar `findAll()` del repository
- Filtrar estudiantes con promedio >= 70
- Usar Stream API:
  - `filter`
  - `count`
- Retornar el total como `Long`

---

## 🚫 Restricciones

- No agregar explicaciones
- No agregar comentarios
- No agregar texto adicional fuera del código
- No generar controladores (a menos que se soliciten después)
- No modificar nombres de paquetes, clases o métodos
- No usar Lombok

---

## 📤 Salida

Devuelve únicamente el código completo con toda la estructura solicitada
--

## **Promt para la clase controller **
# Prompt para la clase `EstudianteController`

Actúa como un desarrollador Senior experto en Java 21, Spring Boot 3, arquitectura REST y Spring MVC.

Tu tarea es implementar la clase existente llamada:

```
EstudianteController
```

---

## 📌 Anotaciones obligatorias

- La clase debe ser un controlador REST usando:
  - `@Controller`
  - `@RequestMapping("/api/estudiantes")`

---

## 🧩 Inyección de dependencias

Usa **inyección por constructor** (no usar `@Autowired` en atributos).

Debes inyectar:

- `EstudianteRepository`
- `EstudianteService`

---

## 🚀 Endpoints requeridos

Implementa los siguientes métodos REST usando `ResponseEntity`:

---

### 1. GET `/`

- Listar todos los estudiantes
- Retorno: `200 OK`

---

### 2. GET `/{id}`

- Buscar estudiante por ID
- Retorno:
  - `200 OK` si existe
  - `404 NOT FOUND` si no existe

---

### 3. GET `/aprobados/total`

- Llama al servicio `contarAprobados()`
- Retorna un `Map<String, Long>` con la estructura:

```json
{
  "totalAprobados": 10
}
```

---

### 4. POST `/`

- Crear un nuevo estudiante
- Retorna:
  - `201 CREATED`

---

### 5. PUT `/{id}`

- Reemplazar completamente el estudiante
- Retorna:
  - `200 OK` si existe
  - `404 NOT FOUND` si no existe

---

### 6. PATCH `/{id}`

- Actualizar solo el campo `grupo`
- Entrada: `Map<String, String>`
- Retorna:
  - `200 OK` si existe
  - `404 NOT FOUND` si no existe

---

### 7. DELETE `/{id}`

- Eliminar estudiante por ID
- Retorna:
  - `204 NO CONTENT` si se elimina
  - `404 NOT FOUND` si no existe

---

## ⚙️ Reglas obligatorias

- Usar `ResponseEntity` en todos los endpoints
- No usar Lombok
- No agregar servicios adicionales
- No cambiar nombres de métodos ni rutas
- No agregar comentarios
- No agregar explicaciones
- Mantener código limpio y estándar Spring Boot 3

---

## 📤 Salida

Devuelve únicamente el código completo de la clase `EstudianteController`, listo para copiar y pegar.


## **.- Promt de creacion del contenido del archivo .gitignore**

>**Con base es la estructura actual del proyecto ingresa la lista completa de elementos dentro del archivo .gitignore de tal manera que solo se suba al repositorio los archivos necesarios para el correcto funcionamiento de la aplicacion de esta manera evitar subir archivos inecesarios al repositorio remoto **

---