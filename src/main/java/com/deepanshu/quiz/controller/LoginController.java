package com.deepanshu.quiz.controller;

import com.deepanshu.quiz.entity.QuizQuestion;
import com.deepanshu.quiz.dto.LoginRequest;
import com.deepanshu.quiz.entity.User;
import com.deepanshu.quiz.service.QuestionService;
import com.deepanshu.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    @PostMapping("/reg")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", "Error registering user"));
        }

    }
        @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
            User authenticatedUser = userService.loginUser(user.getEmail(), user.getPassword());
            if (authenticatedUser != null) {
                return ResponseEntity.ok(Collections.singletonMap("message", "Login successful"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Collections.singletonMap("message", "Invalid credentials"));
            }

        }
    @GetMapping("/questions")
    public List<QuizQuestion> getQuestions() {
        return questionService.getAllQuestions();
    }
     @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public List<QuizQuestion> saveQuestion(@RequestBody List<QuizQuestion> question) {
        return questionService.saveQuestion(question);
    }
     @PostMapping("/del")
      public ResponseEntity<Map<String,String>> deleteQuestion(@RequestBody QuizQuestion quizQuestion){
        String st=questionService.delQuestion(quizQuestion.getId());
        if(!st.isEmpty()){
            return ResponseEntity.ok(Collections.singletonMap("message","Delete successful"));
        }
        else {
            return ResponseEntity.accepted().body(Collections.singletonMap("message","Delete unsuccessful"));
        }
      }



}
