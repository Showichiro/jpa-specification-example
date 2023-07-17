package jpa.specification.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.specification.example.entity.Teacher;
import jpa.specification.example.repository.TeacherRepository;
import jpa.specification.example.specification.TeacherSpecification;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherSpecification teacherSpecification;

    public List<Teacher> findAll(Optional<String> name, Optional<Integer> studentAge) {
        return teacherRepository.findAll(teacherSpecification.buildFindAllSpecification(name, studentAge));
    }

    public List<Teacher> defaultFindAll() {
        return teacherRepository.findAll();
    }
}
