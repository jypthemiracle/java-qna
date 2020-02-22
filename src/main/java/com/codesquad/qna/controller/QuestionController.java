package com.codessquad.qna.controller;

import com.codessquad.qna.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
  private List<Question> questions = new ArrayList<>();

  @PostMapping("/qna/create")
  public String createQuestionPost(Question question) {
    question.setTime();
    question.setIndex(questions.size() + 1); //questions 크기보다 1씩 많게 설정하자.
    questions.add(question);
    return "redirect:/"; //클라이언트의 요청을 처리하고 원래 홈 화면으로 돌아간다.
  }

  @GetMapping() //홈 화면에서는 질문들을 마구마구 보여준다.
  public String showHome(Model model) {
    model.addAttribute("questions", questions);
    return "index";
  }

  @GetMapping("/qna/{index}")
  public Question getArticle(@PathVariable int index, Model model) throws IllegalArgumentException {
    for (Question question : questions) {
      if (index == question.getIndex()) {
        return question;
      }
    }
    throw new IllegalArgumentException("something wrong.");
  }
}