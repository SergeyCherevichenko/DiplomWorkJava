package uz.cherevichenko.exception_handler.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlingAspect {

    @Pointcut("@annotation(HandlerError)")
    public void handlerErrorPointcut() {
    }

    @AfterThrowing(pointcut = "handlerErrorPointcut()", throwing = "ex")
    public void handleException(Exception ex) {
        // Здесь можно обрабатывать исключения
    }
}

