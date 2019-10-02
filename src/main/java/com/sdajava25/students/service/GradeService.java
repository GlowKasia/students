package com.sdajava25.students.service;

import com.sdajava25.students.model.Grade;
import com.sdajava25.students.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    public void add(Grade grade){
        gradeRepository.save(grade);
    }

    public Optional<Grade> findById(Long gradeId){
        return gradeRepository.findById(gradeId);
    }

    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }
}
