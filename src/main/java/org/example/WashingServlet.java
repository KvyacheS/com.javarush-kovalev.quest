package org.example;

import Exceptions.SceneActionException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static constants.TransmissionsConst.BATHROOM;
import static constants.TransmissionsConst.CORRIDOR;
import static constants.WashingConst.*;

@WebServlet("/wash")
public class WashingServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("partToWash") == null) {
            throw new SceneActionException("partToWash is missing");
        }
        String partToWash = request.getParameter("partToWash");
        if (!AVAILABLE_WASH_PARTS.contains(partToWash)) {
            throw new SceneActionException(String.format("partToWash is %s not exists",partToWash));
        }
        switch (partToWash) {
            case TEETH -> session.setAttribute("isCleanTeeth", "true");
            case BODY ->  session.setAttribute("isCleanBody", "true");
        }
        response.sendRedirect(String.format("%s.jsp",BATHROOM));
    }

}
