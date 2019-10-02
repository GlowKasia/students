package com.sdajava25.students.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;
    @CreationTimestamp
    private LocalDateTime dateAdded;
    private double value;


    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }
}
