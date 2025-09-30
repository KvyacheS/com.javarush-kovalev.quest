package org.example;

import Exceptions.SceneTransException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.TransmissionsConst.*;
import static constants.TransmissionsConst.AVAILABLE_TRANS_FROM_CORRIDOR;

@WebServlet("/walk-to")
public class WalkingServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String currentScene =(String) session.getAttribute("currentScene");
        if (request.getParameter("targetScene") == null) {
            throw new SceneTransException("request missing targetScene");
        }
        String targetScene = request.getParameter("targetScene");
        if(!AVAILABLE_SCENES.contains(targetScene)){
            throw new SceneTransException(String.format("targetScene %s not exists", targetScene));
        }

        if (currentScene.equals(targetScene)) {
            throw new SceneTransException("can't move to same Scene");
        }

        List<String> avalaibleScenes = getAvailableScenes(currentScene);
        if (!avalaibleScenes.contains(targetScene)) {
            throw new SceneTransException(String.format("trans from scene %s to scene %s scene is not found",currentScene,targetScene));
        }
        session.setAttribute("currentScene", targetScene);
        response.sendRedirect(String.format("%s.jsp",targetScene));
    }

    private List<String> getAvailableScenes(String scene) {
        return switch (scene) {
            case BATHROOM -> AVAILABLE_TRANS_FROM_BATHROOM;
            case KITCHEN -> AVAILABLE_TRANS_FROM_KITCHEN;
            case CORRIDOR -> AVAILABLE_TRANS_FROM_CORRIDOR;
            default -> new ArrayList<>();
        };
    }

}
