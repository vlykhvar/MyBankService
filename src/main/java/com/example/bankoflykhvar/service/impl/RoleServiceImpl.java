package com.example.bankoflykhvar.service.impl;

import com.example.bankoflykhvar.model.Role;
import com.example.bankoflykhvar.repository.RoleRepository;
import com.example.bankoflykhvar.service.RoleService;
import exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.getByRoleName(roleName).orElseThrow(
                () -> new EntityNotFoundException("Don't find role by name - " + roleName));
    }
}
