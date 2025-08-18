package info.shkryl.useReflection.example2;

import java.lang.reflect.Method;

public class MethodInvocationExample {
    public static void main(String[] args) {
        try {
            // Создаем объект класса
            MyClass obj = new MyClass();

            // Получаем метод setName и вызываем его
            Method method = obj.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(obj, "Новое имя");

            // Получаем метод getName и выводим значение
            Method getMethod = obj.getClass().getDeclaredMethod("getName");
            System.out.println("Имя: " + getMethod.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}