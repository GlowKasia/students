package com.sdajava25.students.service;

import com.sdajava25.students.model.Student;
import com.sdajava25.students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}