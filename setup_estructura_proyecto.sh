#!/bin/bash

# Raíces
MAIN_SRC="src/main/java/com/educa/backend"
TEST_SRC="src/test/java/com/educa/backend"

# 1. Crear estructura de carpetas
echo "🛠️  Creando estructura de carpetas..."
mkdir -p $MAIN_SRC/config
mkdir -p $MAIN_SRC/domain/model/student
mkdir -p $MAIN_SRC/domain/model/user
mkdir -p $MAIN_SRC/domain/repository/student
mkdir -p $MAIN_SRC/domain/repository/user
mkdir -p $MAIN_SRC/dto
mkdir -p $MAIN_SRC/exception
mkdir -p $MAIN_SRC/security
mkdir -p $MAIN_SRC/service/interfaces/student
mkdir -p $MAIN_SRC/service/interfaces/user
mkdir -p $MAIN_SRC/service/impl/student
mkdir -p $MAIN_SRC/service/impl/user
mkdir -p $MAIN_SRC/util
mkdir -p $MAIN_SRC/web/student
mkdir -p $MAIN_SRC/web/user

mkdir -p $TEST_SRC/service/impl/student
mkdir -p $TEST_SRC/service/impl/user
mkdir -p $TEST_SRC/web

# 2. Mover archivos de prueba a las carpetas correctas
echo "📦 Moviendo archivos de prueba..."
find $TEST_SRC -name "UserServiceTest.java" -exec mv {} $TEST_SRC/service/impl/user/UserServiceTest.java \; 2>/dev/null
find $TEST_SRC -name "StudentServiceTest.java" -exec mv {} $TEST_SRC/service/impl/student/StudentServiceTest.java \; 2>/dev/null

# 3. Corregir packages en archivos .java
echo "🧼 Corrigiendo package en todos los archivos .java..."
find $MAIN_SRC $TEST_SRC -name "*.java" | while read file; do
    rel_path=$(realpath --relative-to=src/main/java "$file" | sed 's|/|.|g' | sed 's|.java$||')
    if [[ "$file" == *"/test/"* ]]; then
        rel_path=$(realpath --relative-to=src/test/java "$file" | sed 's|/|.|g' | sed 's|.java$||')
    fi
    pkg="package $rel_path;"
    sed -i "1s|^|$pkg\n\n|" "$file"
done

# 4. Rellenar archivos vacíos con estructura básica
echo "📄 Rellenando archivos vacíos con estructura básica..."
find $MAIN_SRC $TEST_SRC -name "*.java" -size 0 | while read file; do
    class=$(basename "$file" .java)
    pkg=$(dirname "$file" | sed 's|src/main/java/||;s|src/test/java/||;s|/|.|g')
    echo -e "package $pkg;

public class $class {

}" > "$file"
done

echo "✅ Proyecto organizado con éxito."
