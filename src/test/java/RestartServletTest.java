import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.EatingServlet;
import org.example.RestartServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static constants.TransmissionsConst.AVAILABLE_TRANS_FROM_BATHROOM;
import static constants.TransmissionsConst.BATHROOM;
import static org.mockito.Mockito.*;

public class RestartServletTest {

    private RestartServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        servlet = new RestartServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testDoGet_whenExecute_thenClearSession() throws IOException {
        Method method;
        try {
            session.setAttribute("isCleanBody", false);
            session.setAttribute("isCleanTeeth", false);
            session.setAttribute("isEated", false);
            session.setAttribute("isDressed", false);
            session.setAttribute("currentScene", "corridor");
            method = servlet.getClass().getDeclaredMethod("doGet", HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(servlet, request, response);
            Assertions.assertNull(session.getAttribute("isCleanBody"));
            Assertions.assertNull(session.getAttribute("isCleanTeeth"));
            Assertions.assertNull(session.getAttribute("isEated"));
            Assertions.assertNull(session.getAttribute("isDressed"));
            Assertions.assertNull(session.getAttribute("currentRoom"));
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
