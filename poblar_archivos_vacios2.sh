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
      *)
        echo "❓ Tipo no reconocido para $archivo"
        ;;
    esac
  fi
}

# Llamadas a archivos detectados como vacíos (ajusta aquí si agregas más)
poblar_si_vacio "./src/main/java/com/educa/backend/service/interfaces/student/IStudentService.java" service_interface
poblar_si_vacio "./src/test/java/com/educa/backend/service/impl/user/UserServiceTest.java" service_impl

# Dar permisos de ejecución al propio script
chmod +x "$0"

echo "✅ Script finalizado. Archivos vacíos poblados (si había)."
