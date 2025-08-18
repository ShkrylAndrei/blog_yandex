package info.shkryl.useReflection.example1;

import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Создаем объект класса
            MyClass obj = new MyClass();

            // Получаем объект Class и поле name
            Class<?> clazz = obj.getClass();
            Field field = clazz.getDeclaredField("name");

            // Делаем поле доступным для изменения (если оно private)
            field.setAccessible(true);

            // Устанавливаем новое значение поля
            field.set(obj, "Новое значение");

            // Выводим измененное значение поля
            System.out.println("Значение поля name: " + field.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
