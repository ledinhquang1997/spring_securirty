package com.demo.security.bootstrap;

import com.demo.security.Utils.EncrytedPasswordUtils;
import com.demo.security.domain.Role;
import com.demo.security.domain.Account;
import com.demo.security.repository.RoleRepository;
import com.demo.security.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    public DataLoader(RoleRepository roleRepository, AccountRepository accountRepository) {
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role_user = new Role();
        role_user.setRole("ROLE_USER");
        Role saved_role_user = roleRepository.save(role_user);

        Role role_learner = new Role();
        role_learner.setRole("ROLE_LEARNER");
        Role saved_role_learner = roleRepository.save(role_learner);

        Role role_admin = new Role();
        role_admin.setRole("ROLE_ADMIN");
        Role saved_role_admin = roleRepository.save(role_admin);

        Account user1 = new Account();
        user1.setUsername("quang");
        user1.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
        System.out.println(user1.getEncrytedPassword());
        user1.getRoles().add(saved_role_admin);
        user1.getRoles().add(saved_role_user);
        accountRepository.save(user1);

        Account user2 = new Account();
        user2.setUsername("thang");
        user2.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword("123"));
        user2.getRoles().add(saved_role_learner);
        accountRepository.save(user2);


    }

}
