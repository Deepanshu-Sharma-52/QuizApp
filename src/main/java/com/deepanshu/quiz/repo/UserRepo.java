package com.deepanshu.quiz.repo;

import com.deepanshu.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String Email);
}
