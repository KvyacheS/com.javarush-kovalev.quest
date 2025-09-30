
import Exceptions.SceneActionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.WashingServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WashingServletTest {

    private WashingServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        servlet = new WashingServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testDoPost_partToWash_Teeth_ShouldSetisCleanTeeth() throws IOException {
        when(session.getAttribute("isCleanTeeth")).thenReturn("false");
        when(request.getParameter("partToWash")).thenReturn("teeth");

        servlet.doPost(request, response);

        verify(session).setAttribute("isCleanTeeth", "true");
        verify(response).sendRedirect("bathroom.jsp");
    }

    @Test
    void testDoPost_partToWash_Body_ShouldSetisCleanBody() throws IOException {
        when(session.getAttribute("isCleanBody")).thenReturn("false");
        when(request.getParameter("partToWash")).thenReturn("body");

        servlet.doPost(request, response);

        verify(session).setAttribute("isCleanBody", "true");
        verify(response).sendRedirect("bathroom.jsp");
    }

    @Test
    void testDoPost_partToWash_Null_ThrowsSceneActionException() throws IOException {
        when(request.getParameter("partToWash")).thenReturn(null);
        assertThrows(SceneActionException.class, () -> servlet.doPost(request, response));
    }

    @Test
    void testDoPost_partToWash_notExisted_ThrowsSceneActionException() throws IOException {
        when(request.getParameter("partToWash")).thenReturn("null");
        assertThrows(SceneActionException.class, () -> servlet.doPost(request, response));
    }


}
