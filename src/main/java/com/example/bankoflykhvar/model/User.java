package com.example.bankoflykhvar.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "date_birth")
    private LocalDate dateOfBirth;
    @Column(unique = true, nullable = false, name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    private Set<Role> roles;

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", dateOfBirth=" + dateOfBirth
                + ", phoneNumber='" + phoneNumber + '\''
                + '}';
    }
}
