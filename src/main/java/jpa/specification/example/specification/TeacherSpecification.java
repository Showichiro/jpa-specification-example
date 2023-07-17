package jpa.specification.example.specification;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.JoinType;
import jpa.specification.example.entity.Student;
import jpa.specification.example.entity.Teacher;

@Component
public class TeacherSpecification {
    public Specification<Teacher> buildFindAllSpecification(Optional<String> name, Optional<Integer> studentAge) {
        return Specification.where(join())
                .and(name.map(this::byName).orElse(null))
                .and(studentAge.map(this::greaterThanStudentAge).orElse(null));
    }

    private Specification<Teacher> join() {
        return (root, query, builder) -> {
            root.fetch("students", JoinType.INNER);
            return null;
        };
    }

    private Specification<Teacher> byName(String name) {
        return (root, query, builder) -> {
            return builder.equal(root.get("name"), name);
        };
    }

    private Specification<Teacher> greaterThanStudentAge(Integer age) {
        return (root, query, builder) -> {
            return builder.gt(root.<List<Student>>get("students").get("age"), age);
        };
    }
}
