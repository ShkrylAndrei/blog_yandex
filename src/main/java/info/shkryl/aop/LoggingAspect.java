package info.shkryl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // ← Это аспект!
@Component // ← Чтобы Spring увидел его как бин
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Pointcut: применяется ко всем методам в пакете service
     */
    @Pointcut("execution(* info.shkryl.buyingFlyTicket.service.*.*(..))")
    public void serviceLayer() {}

    /**
     * @Before: логируем перед вызовом метода
     */
    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Вызов метода: {}.{} с параметрами: {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                methodName,
                java.util.Arrays.toString(args));
    }

    /**
     * @AfterReturning: логируем результат
     */
    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logAfterSuccess(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Метод {}.{} вернул: {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                methodName,
                result);
    }

    /**
     * @AfterThrowing: логируем исключения
     */
    @AfterThrowing(pointcut = "serviceLayer()", throwing = "exception")
    public void logAfterException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        log.error("Ошибка в методе {}.{}: {}",
                joinPoint.getTarget().getClass().getSimpleName(),
                methodName,
                exception.getMessage());
    }
}
