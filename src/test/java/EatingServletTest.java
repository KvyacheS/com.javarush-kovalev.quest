import Exceptions.SceneActionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.EatingServlet;
import org.example.WashingServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EatingServletTest {

    private EatingServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        servlet = new EatingServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testDoPost_whenIsEatedFalse_thenSetIsEatedTrue() throws IOException {
        when(session.getAttribute("isEated")).thenReturn("false");

        servlet.doPost(request, response);

        verify(session).setAttribute("isEated", "true");
        verify(response).sendRedirect("kitchen.jsp");
    }

    @Test
    void testDoPost_whenIsEatedTrue_thenRedirectToEnding() throws IOException {
        when(session.getAttribute("isEated")).thenReturn("true");
        servlet.doPost(request, response);
        verify(response).sendRedirect("ending.jsp");
    }
}
