package com.license.scanner.licensescanner.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
