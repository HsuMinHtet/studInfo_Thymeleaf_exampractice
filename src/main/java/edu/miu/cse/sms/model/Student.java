package edu.miu.cse.sms.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "students")
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "register_number", unique = true, nullable = false)
    private String registerNumber;
    private String name;
    private String email;
    private String phone;

    public Student(String phone, String email, String name, String registerNumber) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.registerNumber = registerNumber;
    }
}
