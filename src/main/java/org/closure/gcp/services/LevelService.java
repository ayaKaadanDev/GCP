package org.closure.gcp.services;

import org.closure.gcp.entities.LevelEntity;
import org.closure.gcp.exceptions.LevelException;
import org.closure.gcp.models.LevelModel;
import org.closure.gcp.models.UserModel;
import org.closure.gcp.repositories.LevelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {
    

    @Autowired
    LevelRepo levelRepo;

    
    LevelModel levelModel;


    public LevelModel creatLevel (UserModel user , LevelModel level) throws LevelException
    {
        if(levelRepo.findByEmail(user.getEmail()).isEmpty())
        {   
            throw new LevelException("there is no email to creat level");
        }
            
        else 
        {   
            levelRepo.save(levelModelToLevelEntity(level)); 
            return level ;
        }

    }

    public LevelModel updateLevel (LevelModel level , LevelModel creatLevel)  throws LevelException
    {
        if(levelRepo.findById(level.getId()).isEmpty())
        {
             throw new LevelException("there is no level to update it");
        }
        else
        {
            if(quastionRepo.findquastion(creatquastion.get()).isEmpty())
            
                throw new LevelException("can't update now");
            
            else
            {
               if(updateQuastion.getQuastion() = true)
               return new LevelModel() ;
            }
        }

    }

    public LevelModel readLevel (LevelModel level , LevelModel creatLevel) throws LevelException
    {
        if(levelRepo.findById(level.getId()).isEmpty())
        {
            throw new LevelException("there is no level to read it");
        }
        else
            return creatLevel;
    }

    public void deletLevel (LevelModel level)
    {
        if(levelRepo.findById(levelModel.getId()).isEmpty())
            return  ;
        else
        {
            levelRepo.delete(levelModelToLevelEntity(level)); 
            return  ;
    
        }
    }




    public LevelEntity levelModelToLevelEntity(LevelModel level)
    {
         return new LevelEntity()
         .user(level.getUser())
         .questions(level.getQuestions())
         .level(level.getLevel());
    }

    
}
