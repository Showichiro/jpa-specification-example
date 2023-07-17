package jpa.specification.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Student> students = List.of();
}
