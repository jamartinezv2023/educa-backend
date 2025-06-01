#!/bin/bash

# Función para poblar archivo si está vacío
poblar_si_vacio() {
  archivo="$1"
  tipo="$2"

  if [ ! -s "$archivo" ]; then
    echo "📄 Poblando archivo vacío: $archivo"

    case "$tipo" in
      controller)
        cat > "$archivo" <<EOF
package $(echo "$archivo" | sed -E 's|.*/java/||; s|/|.|g; s|\.java$||');

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class $(basename "$archivo" .java) {

}
EOF
        ;;
      service_interface)
        cat > "$archivo" <<EOF
package $(echo "$archivo" | sed -E 's|.*/java/||; s|/|.|g; s|\.java$||');

public interface $(basename "$archivo" .java) {

}
EOF
        ;;
      service_impl)
        cat > "$archivo" <<EOF
package $(echo "$archivo" | sed -E 's|.*/java/||; s|/|.|g; s|\.java$||');

import org.springframework.stereotype.Service;

@Service
public class $(basename "$archivo" .java) {

}
EOF
        ;;
      dto)
        cat > "$archivo" <<EOF
package $(echo "$archivo" | sed -E 's|.*/java/||; s|/|.|g; s|\.java$||');

public class $(basename "$archivo" .java) {

}
EOF
        ;;
      util)
        cat > "$archivo" <<EOF
package $(echo "$archivo" | sed -E 's|.*/java/||; s|/|.|g; s|\.java$||');

public class $(basename "$archivo" .java) {

}
EOF
        ;;
      readme)
        cat > "$archivo" <<EOF
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

\`\`\`
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
\`\`\`

---

## 🛠️ Requisitos

- Java 17+
- Maven 3.6+
- Docker (opcional)
- IDE recomendado: IntelliJ IDEA

---

## 🧪 Cómo ejecutar localmente

\`\`\`bash
# Clona el proyecto
git clone https://github.com/tuusuario/educa-backend.git
cd educa-backend

# Compila y ejecuta el proyecto
./mvnw spring-boot:run

# O usa Docker (requiere docker-compose)
docker-compose up
\`\`\`

Accede a Swagger en: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🧪 Ejecutar tests

\`\`\`bash
./mvnw test
\`\`\`

---

## 📄 Documentación

- Autenticación JWT
- CRUD de usuarios y estudiantes
- Evaluaciones Kolb, Kuder y Felder-Silverman
- Clasificación automática por estilos

(Agrega detalles o enlaces cuando estén disponibles)

---

## 👩‍💻 Autoría

> Proyecto desarrollado por el equipo Educa 2024  
> [Valeria Méndez Escobar](mailto:valeria.mendez@colegio.edu.co) - Grado 11-2

---

## 📜 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más información.
EOF
        ;;
      *)
        echo "❓ Tipo no reconocido para $archivo"
        ;;
    esac
  fi
}

# Llamadas a archivos detectados como vacíos
poblar_si_vacio "./src/main/java/com/educa/backend/service/interfaces/student/IStudentService.java" service_interface
poblar_si_vacio "./src/test/java/com/educa/backend/service/impl/user/UserServiceTest.java" service_impl
poblar_si_vacio "./README.md" readme

# Dar permisos de ejecución al propio script
chmod +x "$0"

echo "✅ Script finalizado. Archivos vacíos poblados (si había)."
