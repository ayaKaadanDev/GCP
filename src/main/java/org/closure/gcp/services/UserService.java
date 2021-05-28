package org.closure.gcp.services;

import org.closure.gcp.entities.UserEntity;
import org.closure.gcp.exceptions.UserException;
import org.closure.gcp.models.Gender;
import org.closure.gcp.models.UserModel;
import org.closure.gcp.repositories.CollageRepo;
import org.closure.gcp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    CollageRepo collageRepo;

    public UserModel registerUser(UserModel user) throws UserException 
    {
        if(user.getEmail() != null && user.getPassword() != null && user.getUsername() != null)
        {
            if(userRepo.findByEmail(user.getEmail()).isEmpty())
            {
                userRepo.save(UserModelToUserEntity(user));
                //TODO mapper from entity to model
                return user;
            }else{
                throw new UserException("this email is already exist");
            }
        }else{
            throw new UserException("required fields are null");
        }


    }


    public UserEntity UserModelToUserEntity(UserModel user)
    {
        return new UserEntity()
            .username(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword())
            .address(user.getAddress())
            .birthday(user.getBirthday())
            .gender(Gender.valueOf(user.getGender() != null ? user.getGender() : "male"))
            .college(
                collageRepo.findByCollageName(
                    user.getCollege()
                    ).get()
                );
                //TODO fix collage mapper
    }
}
