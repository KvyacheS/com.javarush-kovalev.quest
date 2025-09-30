package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static constants.TransmissionsConst.ENDING;

@WebServlet("/sleep")
public class SleepingServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        session.setAttribute("suddenLoseReason","тьма, то есть подушка, поглотила тебя...");
        response.sendRedirect(String.format("%s.jsp",ENDING));
    }

}
