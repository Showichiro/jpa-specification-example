package jpa.specification.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.specification.example.entity.Teacher;
import jpa.specification.example.service.TeacherService;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> findAll(@RequestParam(name = "name", required = false) Optional<String> name,
            @RequestParam(name = "studentAge", required = false) Optional<Integer> studentAge) {
        return teacherService.findAll(name, studentAge);
    }

    @GetMapping("/default/teachers")
    public List<Teacher> defaultFindAll() {
        return teacherService.defaultFindAll();
    }
}
