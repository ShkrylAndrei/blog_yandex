package info.shkryl.useAnnotation.createOwnAnnotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void logMethodCalls(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecution.class)) {
                LogExecution log = method.getAnnotation(LogExecution.class);
                System.out.println("Вызывается метод: " + method.getName());
                System.out.println("  Описание: " + log.value());
                // Здесь можно добавить логику: логировать параметры, время и т.д.
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        logMethodCalls(calc);
    }
}
