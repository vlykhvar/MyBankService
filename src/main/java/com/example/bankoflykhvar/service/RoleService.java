package com.example.bankoflykhvar.service;

import com.example.bankoflykhvar.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String name);
}
