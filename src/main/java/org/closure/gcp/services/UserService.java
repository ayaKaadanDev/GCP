package org.closure.gcp.services;

import java.util.Optional;

import org.closure.gcp.entities.UserEntity;
import org.closure.gcp.exceptions.UserException;
import org.closure.gcp.models.Gender;
import org.closure.gcp.models.UserModel;
import org.closure.gcp.repositories.CollegeRepo;
import org.closure.gcp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    @Autowired
    CollegeRepo collegeRepo;

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

    public UserModel signIn(UserModel user) throws UserException
    {
        Optional<UserEntity> entity;
        if((entity = userRepo.findByEmail(user.getEmail())).isEmpty())
        {
            throw new UserException("no user with this email");
        }else{
            if(entity.get().getPassword().equals(user.getPassword()))
            {
                return userEntityToUserModel(entity.get());
            }else{
                throw new UserException("wrong password");
            }

        }
    }


    public UserEntity UserModelToUserEntity(UserModel user)
    {
        return new UserEntity()
            .name(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword())
            .address(user.getAddress())
            .birthday(user.getBirthday())
            .gender(Gender.valueOf(user.getGender() != null ? user.getGender() : "male"))
            .college(
                collegeRepo.findByCollegeName(
                    user.getCollege()
                    ).get()
                );
                //TODO fix college mapper
    }

    public UserModel userEntityToUserModel(UserEntity user)
    {
        return new UserModel()
            .id(user.getId())
            .username(user.getName())
            .email(user.getEmail())
            .address(user.getAddress())
            .birthday(user.getBirthday())
            .gender(user.getGender().toString())
            .password(user.getPassword());
    }

    
}
