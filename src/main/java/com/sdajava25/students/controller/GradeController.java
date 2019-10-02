package com.sdajava25.students.controller;

import com.sdajava25.students.model.Grade;
import com.sdajava25.students.model.GradeSubject;
import com.sdajava25.students.model.Student;
import com.sdajava25.students.service.GradeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/grade/")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping("/add")
    public String add(Model model, Grade grade) {
        model.addAttribute("grade", grade);
        model.addAttribute("subjects", GradeSubject.values());

        return "grade-add";
    }
    @PostMapping("/add")
    public String add(Grade grade) {
        gradeService.add(grade);

        return "redirect:/student/{studentId}/grades";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<Grade> gradeList = gradeService.getAllGrades();

        model.addAttribute("grades", gradeList);

        return "/student/{studentId}/grades";
    }


    @GetMapping("/grade/edit/{studentId}")
    public String edit(Model model,
                       @PathVariable(name = "edited_grade") Long studentId) {
        return editGrade(model, studentId);
    }
    @GetMapping("/edit")
    public String editParam(Model model,
                            @RequestParam(name = "studentId") Long studentId) {
        return editGrade(model, studentId);
    }
    private String editGrade(Model model, Long studentId) {
        Optional<Grade> gradeOptional = gradeService.findById(studentId);
        if (gradeOptional.isPresent()) {
            model.addAttribute("student", gradeOptional.get());

            return "grade-add";
        }
        return "redirect:/student/{studentId}/grades";
    }

    @GetMapping("/delete")
    public String deleteParam(@RequestParam(name = "studentId") Long id) {
        return deleteGrade(id);
    }

    private String deleteGrade(Long id) {
        gradeService.deleteById(id);

        return "redirect:/student/{studentId}/grades";
    }
}
