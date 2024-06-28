package com.kornienko.quest.servlets;

import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Answer;
import com.kornienko.quest.models.Question;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.QuestionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    private QuestionService questionService;
    private Root root;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        questionService = ((QuestionService) servletContext.getAttribute(Consts.QUESTION_SERVICE));
        root = ((Root) servletContext.getAttribute(Consts.ROOT));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isNull(req.getAttribute("question"))) {
            Question question = root.getQuestions().get(0);

            int firstAnswerID = question.getAnswers().get(0);
            int secondAnswerID = question.getAnswers().get(1);
            Answer firstAnswer = root.getAnswerByQuestionId(firstAnswerID);
            Answer secondAnswer = root.getAnswerByQuestionId(secondAnswerID);

            req.setAttribute("question", question.getTitle());
            req.setAttribute("answer_1", firstAnswer.getTitle());
            req.setAttribute("answer_2", secondAnswer.getTitle());

            req.getRequestDispatcher("/question.jsp").forward(req, resp);
        }
    }
}