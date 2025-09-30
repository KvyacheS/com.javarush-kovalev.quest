package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static constants.TransmissionsConst.*;

@WebServlet("/eat")
public class EatingServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("isEated").equals("true")){
            session.setAttribute("suddenLoseReason","Похоже ты перееел... теперь твой живот  заболел");
            response.sendRedirect(String.format("%s.jsp",ENDING));
            return;
        } else {
            session.setAttribute("isEated", "true");
        }
        response.sendRedirect(String.format("%s.jsp",KITCHEN));
    }

}
