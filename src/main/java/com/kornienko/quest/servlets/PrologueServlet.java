package com.kornienko.quest.servlets;

import com.kornienko.quest.consts.Consts;
import com.kornienko.quest.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "prologueServlet", value = "/")
public class PrologueServlet extends HttpServlet {
    private final Client client = new Client();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(username != null) {
            client.setUsername(username);
            req.getRequestDispatcher(req.getContextPath() + "/question").forward(req, resp);
            return;
        }
        String requestedSessionId = req.getLocalAddr();

        client.setId(requestedSessionId);
        req.getSession().setAttribute(Consts.CLIENT, client);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
