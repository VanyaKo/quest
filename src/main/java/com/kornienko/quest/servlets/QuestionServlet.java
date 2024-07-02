package com.kornienko.quest.servlets;

import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Answer;
import com.kornienko.quest.models.Client;
import com.kornienko.quest.models.Question;
import com.kornienko.quest.models.Result;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.QuestionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        if(isNull(req.getParameter("answerId"))) {
            Client client = ((Client) req.getSession().getAttribute(Consts.CLIENT));
            client.increaseGameCounter();
            Question question = root.getQuestions().get(0);

            handleQuestion(req, resp, question);
        }
        else {
            int answerId = Integer.parseInt(req.getParameter("answerId"));
            Answer answer = root.getAnswers().get(answerId);

            if(hasId(answer.getQuestionId())) {
                Question question = root.getQuestions().get(answer.getQuestionId());
                handleQuestion(req, resp, question);
            } else if(hasId(answer.getResultId())) {
                Result result = root.getResults().get(answer.getResultId());
                req.getSession().setAttribute(Consts.RESULT, result);
                req.getRequestDispatcher("/result.jsp").forward(req, resp);
            }
        }
    }

    private boolean hasId(int id) {
        return id != Consts.DEFAULT_ID;
    }

    private void handleQuestion(HttpServletRequest req, HttpServletResponse resp, Question question) throws ServletException, IOException {
        int firstAnswerID = question.getAnswers().get(0);
        int secondAnswerID = question.getAnswers().get(1);
        Answer firstAnswer = root.getAnswerByQuestionId(firstAnswerID);
        Answer secondAnswer = root.getAnswerByQuestionId(secondAnswerID);

        HttpSession session = req.getSession();
        session.setAttribute("question", question);
        session.setAttribute("answer_1", firstAnswer);
        session.setAttribute("answer_2", secondAnswer);

        req.getRequestDispatcher("/question.jsp").forward(req, resp);
    }
}