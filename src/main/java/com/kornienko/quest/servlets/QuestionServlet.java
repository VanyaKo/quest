package com.kornienko.quest.servlets;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.QuestionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    private QuestionService questionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        questionService = ((QuestionService) servletContext.getAttribute(Consts.QUESTION_SERVICE));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        questionService = new QuestionService(new ObjectMapper());
        Root root = questionService.readFromFile("root.json");

        request.setAttribute("question", root.getQuestions().get(0).getTitle());
        request.setAttribute("answer_1", root.getQuestions().get(0).getChoices().get(0));
        request.setAttribute("answer_2", root.getQuestions().get(0).getChoices().get(1));


    }
}