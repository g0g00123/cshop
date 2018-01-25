package io.ermdev.cshop.core.config;

import io.ermdev.cshop.data.repository.RoleRepository;
import io.ermdev.cshop.data.repository.TokenRepository;
import io.ermdev.cshop.data.repository.UserRepository;
import io.ermdev.cshop.data.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitConfiguration implements CommandLineRunner {

    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private UserRoleRepository userRoleRepo;
    private TokenRepository tokenRepository;

    @Autowired
    public DatabaseInitConfiguration(UserRepository userRepo, RoleRepository roleRepo, UserRoleRepository userRoleRepo,
                                     TokenRepository tokenRepository) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.userRoleRepo = userRoleRepo;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        userRepo.createTable();
        roleRepo.createTable();
        userRoleRepo.createTable();
        tokenRepository.createTable();
    }
}
