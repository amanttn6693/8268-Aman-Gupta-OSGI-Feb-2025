package com.ttn.demo.core.services;

import com.ttn.demo.core.models.Student;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(service = StudentClassService.class)
public class StudentClassServiceImpl implements StudentClassService {
    private final List<Student> studentList = new ArrayList<>();

    public StudentClassServiceImpl() {
        students.add(new Students(1, "Aman", 75, 23));
        students.add(new Students(2, "Kunal", 28, 19));
        students.add(new Students(3, "Amit", 45, 25));
        students.add(new Students(4, "Nitesh", 60, 21));
        students.add(new Students(5, "Vaibhav", 74, 23));
        students.add(new Students(6, "Akshat", 50, 13));
        students.add(new Students(7, "Pankaj", 66, 87));
        students.add(new Students(8, "Om", 72, 24));
    }

    @Override
    public String addStudent(Student student) {
        studentList.add(student);
        return "Student added: " + student.getName();
    }

    @Override
    public String deleteStudent(int id) {
        return studentList.removeIf(s -> s.getId() == id) ? "Student removed successfully" : "Student not found";
    }

    @Override
    public boolean isStudentPassed(int id) {
        return studentList.stream().anyMatch(s -> s.getId() == id && s.getMarks() >= 40);
    }

    @Override
    public Student getStudent(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }
}
