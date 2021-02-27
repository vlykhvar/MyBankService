package com.example.bankoflykhvar.initialize;

import com.example.bankoflykhvar.model.Role;
import com.example.bankoflykhvar.model.User;
import com.example.bankoflykhvar.service.RoleService;
import com.example.bankoflykhvar.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitialize {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitialize(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addUser() {
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setRoles(Set.of(userRole));
        user.setName("admin");
        user.setPassword("123");
        user.setPhoneNumber("0445729402");
        LocalDate localDate = LocalDate.of(1992, 06, 12);
        user.setDateOfBirth(localDate);
        userService.add(user);
    }
}
