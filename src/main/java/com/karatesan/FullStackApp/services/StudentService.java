package com.karatesan.FullStackApp.services;

import com.karatesan.FullStackApp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    public List<Student> getAllStudents() {
        return List.of(new Student(10L, "Dupa", "Kupa", "dupa@dupa.pl", Student.Gender.MALE),
                new Student(11L, "Dupa2", "Kupa2", "dupa2@dupa.pl", Student.Gender.MALE));
    }
}
