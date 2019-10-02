package com.sdajava25.students.controller;

import com.sdajava25.students.model.Student;
import com.sdajava25.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/student/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/add")
    public String add(Model model, Student student) {
        model.addAttribute("student", student);
        return "student-add";
    }

    @PostMapping("/add")
    public String add(Student student) {
        studentService.add(student);

        return "redirect:/student/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Student> studentList = studentService.getAllStudents();

        model.addAttribute("students", studentList);

        return "student-list";
    }


    @GetMapping("/edit/{edited_student_id}")
    public String edit(Model model,
                       @PathVariable(name = "edited_student_id") Long studentId) {
        return editStudent(model, studentId);
    }

    //    2 edit z request param
    @GetMapping("/edit")
    public String editParam(Model model,
                            @RequestParam(name = "studentId") Long studentId) {
        return editStudent(model, studentId);
    }

    private String editStudent(Model model, Long studentId) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());

            return "student-add";
        }
        return "redirect:/student/list";
    }


    @GetMapping("/delete/{delete_id}")
    public String delete(@PathVariable(name = "delete_id") Long id) {
        return deleteStudent(id);
    }
//    3 delete z request param

    @GetMapping("/delete")
    public String deleteParam(@RequestParam(name = "studentId") Long id) {
        return deleteStudent(id);
    }

    private String deleteStudent(Long id) {
        studentService.deleteById(id);

        return "redirect:/student/list";
    }
}
