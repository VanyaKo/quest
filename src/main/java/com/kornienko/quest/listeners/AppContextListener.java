package com.kornienko.quest.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.models.Client;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.QuestionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.kornienko.quest.consts.Consts;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        Client client = new Client();
        QuestionService questionService = new QuestionService(new ObjectMapper());
        Root root = questionService.readFromFile("root.json");

        servletContext.setAttribute(Consts.CLIENT, client);
        servletContext.setAttribute(Consts.QUESTION_SERVICE, questionService);
        servletContext.setAttribute(Consts.ROOT, root);

        ServletContextListener.super.contextInitialized(sce);
    }
}