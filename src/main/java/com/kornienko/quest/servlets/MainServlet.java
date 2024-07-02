package com.kornienko.quest.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Client;
import com.kornienko.quest.models.Root;
import com.kornienko.quest.services.QuestionService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Frequency;

import java.io.IOException;

@WebServlet(name = "mainServlet", value = "/main")
public class MainServlet extends HttpServlet  {
    private Client client;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        client = ((Client) servletContext.getAttribute(Consts.CLIENT));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedSessionId = req.getLocalAddr();
        String username = req.getParameter("username");

        client.setId(requestedSessionId);
        client.setUsername(username);
        req.getSession().setAttribute(Consts.CLIENT, client);

        resp.sendRedirect(req.getContextPath() + "/question");
    }
}
