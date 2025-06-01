# 📚 Educa Backend

Backend del sistema educativo **Educa**, desarrollado en Java con Spring Boot, siguiendo principios SOLID, arquitectura por capas y convenciones de código limpio. Este servicio expone APIs RESTful seguras para gestionar usuarios, estudiantes, autenticación y evaluaciones psicológicas.

---

## 🚀 Tecnologías utilizadas

- ☕ Java 17
- 🧪 JUnit 5
- 🌱 Spring Boot 3
- 🔐 Spring Security + JWT
- 🔄 Maven
- 🧰 Lombok
- 🌐 Swagger (OpenAPI)
- 🐘 PostgreSQL / H2 (dev)
- 🐳 Docker

---

## 📁 Estructura del proyecto

```
com.educa.backend
├── config               # Configuraciones globales (seguridad, swagger, etc.)
├── domain              
│   ├── model           # Entidades del dominio
│   └── repository      # Interfaces de persistencia
├── dto                 # DTOs y Mappers
├── exception           # Manejador global de excepciones
├── security            # Filtros y utilidades JWT
├── service             
│   ├── interfaces      # Interfaces de los servicios
│   └── impl            # Implementaciones de servicios
├── util                # Constantes y clases utilitarias
└── web                 # Controladores REST (divididos por dominio)
```

---

## 🛠️ Requisitos

- Java 17+
- Maven 3.6+
- Docker (opcional)
- IDE recomendado: IntelliJ IDEA

---

## 🧪 Cómo ejecutar localmente

```bash
# Clona el proyecto
git clone https://github.com/jamartinezv2023/educa-backend.git
cd educa-backend

# Compila y ejecuta el proyecto
./mvnw spring-boot:run

# O usa Docker (requiere docker-compose)
docker-compose up
```

Accede a Swagger en: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🧪 Ejecutar tests

```bash
./mvnw test
```

---

## 📄 Documentación

- Autenticación JWT
- CRUD de usuarios y estudiantes
- Evaluaciones Kolb, Kuder y Felder-Silverman
- Clasificación automática por estilos

(Agrega detalles o enlaces cuando estén disponibles)

---

## 👩‍💻 Autoría

> Proyecto desarrollado por el equipo Educa 2025  
> [José Alfredo Martínez Valdés](mailto:jose.martinez7@udea.edu.co) - Universidade de Antioquia

---

## 📜 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.
# educa-backend
# educa-backend
# educa-backend
