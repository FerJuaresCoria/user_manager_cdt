# User Manager

[Manual en Notion](https://www.notion.so/User-Manager-119de625d28a803aa54ed797fff7a5ea?pvs=4)

# Documentación del Proyecto Java con Spring Boot

## 1. Introducción

Administrador de usuarios como prueba tecnica para CDT

## 2. Requisitos del Sistema

- Java JDK (21)
- Maven
- IntelliJ (recomendado)

## 3. Configuración del Proyecto

### 3.1 Estructura del Proyecto

Microservicio API programada en Java 21 con framework Spring Boot, Maven como gestor de dependencias, MySQL como motor de base de datos, y testeado con JUnit y Mockito.

### 3.2 Dependencias

- Spring boot starter web
- Spring boot starter test
- Spring boot starter data jpa
- MySQL connector java
- H2
- SpringDoc OpenApi starter WebMVC UI

## 4. Arquitectura

MIcroservicio API Rest basada en arquitectura de microservicio por su simplicidad a la hora de generar un CRUD de usuarios.

Sus capaz son:

- Controller
- Service
- Repository
- Domain

## 5. Configuración de Spring Boot

Tenemos dos configuraciones: `application.properties` y `application-test.properties`

Configuraciones de la aplicación:

- application.properties:
    - Utilizado principalmente para ambientes productivos
    - Configuraciones para el uso de Base de Datos MySQL
- application-test.properties:
    - Configuración para pruebas locales
    - Utiliza una base de datos H2 para un uso más ligero en las pruebas

## 6. Modelos de Datos

- UserData: Objeto con la informacion principal de los usuarios

## 7. Repositorios

- Users: Interfaz que maneja el conjunto de usuarios

## 8. Servicios

- UsermanagerService: Servicio que maneja la logica principal del controlador

## 9. Controladores

- UsermanagerController: Unico controlador con endpoints de alta y obtencion de usuarios

## 10. Pruebas

Se generaron pruebas sobre el alta y obtencion de usuarios. Para mayor informacion, consulte las pruebas escritas en el codigo.

## 11. API Documentation

Una vez desplegado el proyecto, visite http://localhost:8080/swagger-ui/index.html

## 12. Despliegue
### 12.1. Clonar el Repositorio

Para comenzar, clone el repositorio del proyecto utilizando Git:

```bash
git clone https://github.com/FerJuaresCoria/user_manager_cdt.git
cd user_manager_cdt
```

### 12.2. Configurar Maven

Asegúrese de tener Maven instalado en su sistema. Puede verificarlo con:

```bash
mvn -version
```

Si no está instalado, descárguelo e instálelo desde [maven.apache.org](https://maven.apache.org/download.cgi).

### 12.3. Configurar la Base de Datos MySQL

#### MySQL

- Instale MySQL si aún no lo tiene: [Descargar MySQL](https://dev.mysql.com/downloads/mysql/)
- Cree una nueva base de datos para el proyecto:

```sql
CREATE DATABASE nombre_de_la_base_de_datos;
```

- Cree un usuario y otorgue permisos:

```sql
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'contraseña';
GRANT ALL PRIVILEGES ON nombre_de_la_base_de_datos.* TO 'usuario'@'localhost';
FLUSH PRIVILEGES;
```

#### MySQL Workbench

Alternativamente, puede utilizar MySQL Workbench para configurar la base de datos de manera visual:

- Descargue e instale MySQL Workbench desde [dev.mysql.com/downloads/workbench/](https://dev.mysql.com/downloads/workbench/)
- Abra MySQL Workbench y conéctese a su servidor MySQL local
- Cree una nueva base de datos haciendo clic derecho en el panel de SCHEMAS y seleccionando "Create Schema"
- Para crear un nuevo usuario, vaya a Administration > Users and Privileges, luego haga clic en "Add Account"
- Asigne los privilegios necesarios al nuevo usuario para la base de datos creada

### 12.4. Configurar la Conexión a la Base de Datos

Busque el archivo de configuración de la base de datos en el proyecto (usualmente en src/main/resources) y actualice los detalles de conexión:

```
spring.datasource.url=jdbc:mysql://localhost:3306/users
spring.datasource.password=contraseña
```

En caso de ser necesario, recuerde agregar correctamente la ruta y las credenciales correctas en el archivo de configuracion `application.properties`

### 12.5. Compilar el Proyecto

Compile el proyecto usando Maven:

```bash
mvn clean install
```

### 12.6. Ejecutar la Aplicación

Para ejecutar la aplicación, use:

```bash
mvn spring-boot:run
```

### 12.7. Verificar la Instalación

Acceda a la aplicación a través de su navegador web o herramienta de prueba de API (Como [Postman](https://www.postman.com/) o [Imsomnia](https://insomnia.rest/download)) para verificar que está funcionando correctamente.

