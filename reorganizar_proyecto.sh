#!/bin/bash

echo "🔧 Creando carpetas necesarias..."
mkdir -p src/main/java/com/educa/backend/domain/model/student
mkdir -p src/main/java/com/educa/backend/domain/model/user
mkdir -p src/main/java/com/educa/backend/domain/repository/student
mkdir -p src/main/java/com/educa/backend/domain/repository/user
mkdir -p src/main/java/com/educa/backend/service/interfaces/student
mkdir -p src/main/java/com/educa/backend/service/interfaces/user
mkdir -p src/test/java/com/educa/backend/service/impl/student
mkdir -p src/test/java/com/educa/backend/service/impl/user

echo "🚚 Moviendo archivos a sus ubicaciones correctas..."
# Modelos
mv src/main/java/com/educa/backend/domain/model/Student.java src/main/java/com/educa/backend/domain/model/student/
mv src/main/java/com/educa/backend/domain/model/User.java src/main/java/com/educa/backend/domain/model/user/

# Repositorios
mv src/main/java/com/educa/backend/domain/repository/StudentRepository.java src/main/java/com/educa/backend/domain/repository/student/
mv src/main/java/com/educa/backend/domain/repository/UserRepository.java src/main/java/com/educa/backend/domain/repository/user/

# Interfaces de servicios
mv src/main/java/com/educa/backend/service/interfaces/IUserService.java src/main/java/com/educa/backend/service/interfaces/user/

# Servicios de implementación
mv src/main/java/com/educa/backend/service/impl/StudentService.java src/main/java/com/educa/backend/service/impl/student/
mv src/main/java/com/educa/backend/service/impl/StudentServiceImpl.java src/main/java/com/educa/backend/service/impl/student/
mv src/main/java/com/educa/backend/service/impl/UserService.java src/main/java/com/educa/backend/service/impl/user/
mv src/main/java/com/educa/backend/service/impl/UserServiceImpl.java src/main/java/com/educa/backend/service/impl/user/

# Tests
mv src/test/java/com/educa/backend/UserServiceTest.java src/test/java/com/educa/backend/service/impl/user/UserServiceTest.java

echo "✅ Archivos movidos."
