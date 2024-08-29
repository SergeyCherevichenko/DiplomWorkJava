package uz.cherevichenko.exception_handler.aspect;



import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlingAspect {

    @Pointcut("@annotation(uz.cherevichenko.exception_handler.handler_error.HandlerError)")
    public void handlerErrorPointcut() {
    }

    @AfterThrowing(pointcut = "handlerErrorPointcut()", throwing = "ex")
    public void handleException(Exception ex) {
    }
    }