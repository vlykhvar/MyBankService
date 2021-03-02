package com.example.bankoflykhvar.initialize;

import com.example.bankoflykhvar.lib.Currency;
import com.example.bankoflykhvar.model.Account;
import com.example.bankoflykhvar.model.Role;
import com.example.bankoflykhvar.model.User;
import com.example.bankoflykhvar.service.AccountService;
import com.example.bankoflykhvar.service.RoleService;
import com.example.bankoflykhvar.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final AccountService accountService;

    @Autowired
    public DataInitializer(UserService userService,
                           RoleService roleService,
                           AccountService accountService) {
        this.userService = userService;
        this.roleService = roleService;
        this.accountService = accountService;
    }

    @PostConstruct
    public void initializeApp() {
        addUser();
        addAccount();
    }

    private void addAccount() {
        Account account = new Account();
        account.setActive(true);
        account.setAccountNumber("000001");
        account.setBalance(BigDecimal.valueOf(1000000));
        account.setCurrency(Currency.USD);
        account.setUser(userService.findByPhoneNumber("00000"));
        accountService.add(account);
    }

    private void addUser() {
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.save(userRole);
        User user = new User();
        user.setRoles(Set.of(userRole));
        user.setName("admin");
        user.setPassword("123");
        user.setPhoneNumber("00000");
        LocalDate localDate = LocalDate.of(1992, 06, 12);
        user.setDateOfBirth(localDate);
        userService.save(user);
    }
}
