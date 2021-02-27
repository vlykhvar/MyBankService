package com.example.bankoflykhvar.dao;

import com.example.bankoflykhvar.model.Role;
import java.util.Optional;

public interface RoleDao extends Dao<Role> {
    Optional<Role> getByName(String name);
}
