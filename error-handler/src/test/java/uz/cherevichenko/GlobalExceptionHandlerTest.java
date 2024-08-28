package uz.cherevichenko;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import uz.cherevichenko.exception_handler.config.ErrorHandlerProperties;
import uz.cherevichenko.exception_handler.exception.AccessDeniedException;
import uz.cherevichenko.exception_handler.exception.InvalidInputException;
import uz.cherevichenko.exception_handler.exception.ResourceNotFoundException;
import uz.cherevichenko.exception_handler.global_exception_handler.GlobalExceptionHandler;
import uz.cherevichenko.exception_handler.model.ErrorDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = App.class)
public class GlobalExceptionHandlerTest {

    @Mock
    private ErrorHandlerProperties errorHandlerProperties;

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleGlobalException_Enabled() {
        Exception ex = new Exception("Global error");
        WebRequest request = mock(WebRequest.class);
        when(errorHandlerProperties.isEnabled()).thenReturn(true);
        when(request.getDescription(false)).thenReturn("some details");

        ResponseEntity<?> response = globalExceptionHandler.handleGlobalException(ex, request);

        ErrorDetails errorDetails = (ErrorDetails) response.getBody();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatusCodeValue());
        assertEquals("Global error", errorDetails.getMessage());
    }

    @Test
    public void testHandleResourceNotFoundException_Enabled() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        WebRequest request = mock(WebRequest.class);
        when(errorHandlerProperties.isResourceNotFoundEnabled()).thenReturn(true);
        when(request.getDescription(false)).thenReturn("details");

        ResponseEntity<?> response = globalExceptionHandler.handleResourceNotFoundException(ex, request);

        ErrorDetails errorDetails = (ErrorDetails) response.getBody();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCodeValue());
        assertEquals("Resource not found", errorDetails.getMessage());
    }

    @Test
    public void testHandleInvalidInputException_Enabled() {
        InvalidInputException ex = new InvalidInputException("Invalid input");
        WebRequest request = mock(WebRequest.class);
        when(errorHandlerProperties.isInvalidInputEnabled()).thenReturn(true);
        when(request.getDescription(false)).thenReturn("details");

        ResponseEntity<?> response = globalExceptionHandler.handleInvalidInputException(ex, request);

        ErrorDetails errorDetails = (ErrorDetails) response.getBody();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCodeValue());
        assertEquals("Invalid input", errorDetails.getMessage());
    }

    @Test
    public void testHandleAccessDeniedException_Enabled() {
        AccessDeniedException ex = new AccessDeniedException("Access denied");
        WebRequest request = mock(WebRequest.class);
        when(errorHandlerProperties.isAccessDeniedEnabled()).thenReturn(true);
        when(request.getDescription(false)).thenReturn("details");

        ResponseEntity<?> response = globalExceptionHandler.handleAccessDeniedException(ex, request);

        ErrorDetails errorDetails = (ErrorDetails) response.getBody();

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatusCodeValue());
        assertEquals("Access denied", errorDetails.getMessage());
    }
}
