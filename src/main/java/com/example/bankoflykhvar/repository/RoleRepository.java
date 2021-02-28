package com.example.bankoflykhvar.repository;

import com.example.bankoflykhvar.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("FROM Role WHERE roleName = ?1")
    Optional<Role> getByName(String name);
}
