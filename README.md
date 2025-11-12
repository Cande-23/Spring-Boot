# Spring-Boot

# Productos API

API REST para la gestión de productos (Trabajo Práctico - Programación III)

## Descripción
API para un mini e-commerce que permite crear, listar, filtrar, actualizar y eliminar productos. Implementa validaciones, manejo centralizado de errores, persistencia con Spring Data JPA e H2 y documentación con Swagger/OpenAPI.

## Tecnologías
- Java 17
- Spring Boot 3.x
- Spring Web, Spring Data JPA
- H2 (in-memory)
- Bean Validation
- Lombok
- springdoc-openapi (Swagger UI)
- Maven

## Ejecutar localmente (IntelliJ)
1. Clonar repo
2. Abrir en IntelliJ como proyecto Maven
3. Ejecutar `ProductosApiApplication` (Run)
4. Acceder:
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`
   - H2 Console: `http://localhost:8080/h2-console`  
     - JDBC URL: `jdbc:h2:mem:productosdb`, user `sa`, sin password

## Endpoints principales
| Método | Ruta | Descripción |
|---|---:|---|
| GET | `/api/productos` | Listar todos |
| GET | `/api/productos/{id}` | Obtener por id |
| GET | `/api/productos/categoria/{categoria}` | Filtrar por categoría |
| POST | `/api/productos` | Crear producto (body: ProductoDTO) |
| PUT | `/api/productos/{id}` | Actualizar todo (body: ProductoDTO) |
| PATCH | `/api/productos/{id}/stock` | Actualizar stock (body: ActualizarStockDTO) |
| DELETE | `/api/productos/{id}` | Eliminar (204) |

## Validaciones importantes
- `nombre`: obligatorio, 3-100 caracteres
- `descripcion`: max 500
- `precio`: >= 0.01
- `stock`: >= 0
- `categoria`: obligatoria (ELECTRONICA, ROPA, ALIMENTOS, HOGAR, DEPORTES)

## Conclusión de lo aprendido
A través de este trabajo aprendí cómo documentar y probar una API REST utilizando Swagger UI, lo que facilita la comunicación entre el backend y los usuarios o testers. También comprendí cómo funciona la base de datos H2 para persistir datos en memoria durante el desarrollo, y cómo validar correctamente los datos para manejar errores como 400 o 404. En general, me ayudó a entender mejor el flujo completo de una API, desde su creación hasta las pruebas de endpoints.

## Autor
Maria Candela Gonzalez Pujado — Legajo: 46355
