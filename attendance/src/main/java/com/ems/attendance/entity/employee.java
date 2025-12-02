package com.ems.attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class employee {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String name;
        @Email
        private String email;
        @Size(min=8, max=10)
        private String phone;
        private String gender;
        private float salary;

        @ManyToOne
        @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
        private department department;

        private String role;
}
