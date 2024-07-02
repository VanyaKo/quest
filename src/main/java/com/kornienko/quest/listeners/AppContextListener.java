package com.kornienko.quest.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.JsonService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        JsonService jsonService = new JsonService(new ObjectMapper());
        Root root = jsonService.readFromFile(Consts.PATH_TO_JSON);
        servletContext.setAttribute(Consts.ROOT, root);

        ServletContextListener.super.contextInitialized(sce);
    }
}