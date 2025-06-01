#!/bin/bash

# Script: poblar_archivos_vacios.sh
# Descripción: Población automática de archivos Java vacíos con contenido base

echo "package com.educa.backend.service.interfaces.student;

import com.educa.backend.dto.student.StudentDTO;
import java.util.List;

public interface IStudentService {
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}" > "src/main/java/com/educa/backend/service/interfaces/student/IStudentService.java"
echo "package com.educa.backend.service.interfaces.user;

import com.educa.backend.dto.user.UserDTO;
import java.util.List;

public interface IUserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}" > "src/main/java/com/educa/backend/service/interfaces/user/IUserService.java"
echo "package com.educa.backend.service.impl.student;

// StudentService (class or utility)" > "src/main/java/com/educa/backend/service/impl/student/StudentService.java"
echo "package com.educa.backend.service.impl.student;

import com.educa.backend.dto.student.StudentDTO;
import com.educa.backend.service.interfaces.student.IStudentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Override
    public StudentDTO getStudentById(Long id) {
        return null; // TODO
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return null; // TODO
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return null; // TODO
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        return null; // TODO
    }

    @Override
    public void deleteStudent(Long id) {
        // TODO
    }
}" > "src/main/java/com/educa/backend/service/impl/student/StudentServiceImpl.java"
echo "package com.educa.backend.service.impl.user;

// UserService (class or utility)" > "src/main/java/com/educa/backend/service/impl/user/UserService.java"
echo "package com.educa.backend.service.impl.user;

import com.educa.backend.dto.user.UserDTO;
import com.educa.backend.service.interfaces.user.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public UserDTO getUserById(Long id) {
        return null; // TODO
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null; // TODO
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null; // TODO
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null; // TODO
    }

    @Override
    public void deleteUser(Long id) {
        // TODO
    }
}" > "src/main/java/com/educa/backend/service/impl/user/UserServiceImpl.java"
echo "package com.educa.backend.web.student;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(\"/api/students\")
public class StudentController {
    // TODO: Implement endpoints
}" > "src/main/java/com/educa/backend/web/student/StudentController.java"
echo "package com.educa.backend.web.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(\"/api/users\")
public class UserController {
    // TODO: Implement endpoints
}" > "src/main/java/com/educa/backend/web/user/UserController.java"
echo "package com.educa.backend.util;

public class AppConstants {
    public static final String DEFAULT_ROLE = \"ROLE_USER\";
}" > "src/main/java/com/educa/backend/util/AppConstants.java"
