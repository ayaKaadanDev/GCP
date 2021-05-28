package org.closure.gcp.controllers;

import org.closure.gcp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserRepo userRepo;

    
}
