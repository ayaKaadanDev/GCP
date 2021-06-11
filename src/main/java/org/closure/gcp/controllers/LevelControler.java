
package org.closure.gcp.controllers;

import org.closure.gcp.exceptions.LevelException;
import org.closure.gcp.models.LevelModel;
import org.closure.gcp.models.UserModel;
import org.closure.gcp.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/level")
public class LevelControler {
    

    @Autowired
    LevelService levelService;


    @RequestMapping(value="/creatLevel", method=RequestMethod.GET)
    public Object creatLevel (UserModel user , LevelModel level) throws Exception {
        try {
             return    levelService.creatLevel(user, level) ;
        } catch (Exception e) {
            return e.getMessage();
        }
        
        
    }

    @RequestMapping(value="/updateLevel", method=RequestMethod.GET)
    public Object updateLevel (LevelModel level , LevelModel creatLevel)  throws LevelException {
        try {
            return levelService.updateLevel(level , creatLevel);
       } catch (Exception e) {
           return e.getMessage();
       }
        
       
    }
   
    @RequestMapping(value="/read", method=RequestMethod.GET)
    public Object readLevel (LevelModel level , LevelModel creatLevel) throws LevelException {
        try {
            return levelService.readLevel(level , creatLevel);
       } catch (Exception e) {
           return e.getMessage();
       }
        
        
    }

    @RequestMapping(value="/deletLevel", method=RequestMethod.GET)
    public void deletLevel (LevelModel level) {
         levelService.deletLevel(level);
    }
}
