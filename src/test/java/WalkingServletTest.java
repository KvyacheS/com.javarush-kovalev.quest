import Exceptions.SceneActionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.WalkingServlet;
import org.example.WashingServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import static constants.TransmissionsConst.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class WalkingServletTest {

    private WalkingServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        servlet = new WalkingServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testGetAvailableScenes_Bathroom_return_AvailableTransFromBathroom() throws IOException {
        Method method;
        try {
            method = servlet.getClass().getDeclaredMethod("getAvailableScenes",String.class);
            method.setAccessible(true);
            Object actual = method.invoke(servlet, BATHROOM);
            Assertions.assertEquals(AVAILABLE_TRANS_FROM_BATHROOM,actual);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAvailableScenes_Kitchen_return_AvailableTransFromKitchen() throws IOException {
        Method method;
        try {
            method = servlet.getClass().getDeclaredMethod("getAvailableScenes",String.class);
            method.setAccessible(true);
            Object actual = method.invoke(servlet, KITCHEN);
            Assertions.assertEquals(AVAILABLE_TRANS_FROM_KITCHEN,actual);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAvailableScenes_Corridor_return_AvailableTransFromCorridor() throws IOException {
        Method method;
        try {
            method = servlet.getClass().getDeclaredMethod("getAvailableScenes",String.class);
            method.setAccessible(true);
            Object actual = method.invoke(servlet, CORRIDOR);
            Assertions.assertEquals(AVAILABLE_TRANS_FROM_CORRIDOR,actual);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
