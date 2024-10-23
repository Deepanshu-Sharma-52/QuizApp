package com.deepanshu.quiz.service;


import com.deepanshu.quiz.dto.LoginRequest;
import com.deepanshu.quiz.entity.User;
import com.deepanshu.quiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
       @Autowired
       UserRepo userRepo;

       public void registration(User user){
             userRepo.save(user);
       }

       public User loginUser(String email, String password){
           User user =userRepo.findByEmail(email);
           if(user!=null && user.getPassword().equals(password)){
               return user;
           }
           return null;
       }
}
