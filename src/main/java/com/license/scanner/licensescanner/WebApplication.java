package com.license.scanner.licensescanner;

import com.license.scanner.licensescanner.model.Role;
import com.license.scanner.licensescanner.model.User;
import com.license.scanner.licensescanner.repository.RoleRepository;
import com.license.scanner.licensescanner.service.UserService;
import com.license.scanner.licensescanner.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args)  {
        SpringApplication.run(WebApplication.class, args);
    }

    /**
     * Load initial data
     * @param args
     */
    @Override
    public void run(String... args) {

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role restaurantRole = new Role();
        restaurantRole.setName("RESTAURANT");

        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(restaurantRole);

        roleRepository.saveAll(roles);

        User adminUser = new User();

        adminUser.setIsAdmin(true);
        adminUser.setPassword("Admin@1234");
        adminUser.setFirstName("Admin");
        adminUser.setUsername("lsadmin");

        userService.save(adminUser);
    }
}
