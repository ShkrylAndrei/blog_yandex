package info.shkryl.useAnnotation.createOwnAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogExecution {
    // Параметры аннотации (опционально)
    String value() default ""; // Например, описание операции

    boolean logParameters() default true;

    boolean logResult() default true;
}
