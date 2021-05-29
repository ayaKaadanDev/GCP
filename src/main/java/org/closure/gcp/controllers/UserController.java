package org.closure.gcp.controllers;

import org.closure.gcp.exceptions.UserException;
import org.closure.gcp.models.UserModel;
import org.closure.gcp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/api/v1/auth")
public class UserController {
    
   @Autowired
   UserService userService;

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public Object registerUser(@RequestBody UserModel user) {
        try{
            return userService.registerUser(user);
        }catch(UserException e)
        {
            return e.getMessage();
        }
    }
    

    @RequestMapping(value="/signin", method=RequestMethod.POST)
    public Object signIn(@RequestBody UserModel user) {
        try{
            return userService.signIn(user);
        }catch(UserException e)
        {
            return e.getMessage();
        }
    }
    


}
