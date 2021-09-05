package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.User;
import com.license.scanner.licensescanner.model.dto.UserDto;
import com.license.scanner.licensescanner.repository.RoleRepository;
import com.license.scanner.licensescanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getIsAdmin()){
            user.setRoles(roleRepository.findByNameIgnoreCaseIsContaining("admin"));
        }
        else{
            user.setRoles(roleRepository.findByNameIgnoreCaseIsContaining("restaurant"));
        }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> getAllUsers(){
        return userMapper.toDto(userRepository.findAll());
    }
}
