package com.deepanshu.quiz.service;

import com.deepanshu.quiz.entity.QuizQuestion;
import com.deepanshu.quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<QuizQuestion> getAllQuestions()
    {
        List<QuizQuestion> questionRepoAll = questionRepo.findAll();
        return questionRepoAll;
    }

    public List<QuizQuestion> saveQuestion(List<QuizQuestion> question){
        List<QuizQuestion> save = questionRepo.saveAll(question);
        return save;
    }

    public String delQuestion(Long id){
        questionRepo.deleteById(id);
        return "Delete successful";
    }
}
