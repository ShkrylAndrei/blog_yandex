package info.shkryl.useReflection.example3;

import java.lang.reflect.Constructor;

public class ConstructorExample {
    public static void main(String[] args) {
        try {
            // Получаем объект Class
            Class<?> clazz = MyClass.class;

            // Получаем конструктор с параметрами
            Constructor<?> constructor = clazz.getConstructor(String.class);

            // Создаем новый экземпляр объекта используя конструктор
            MyClass obj = (MyClass) constructor.newInstance("Создано через рефлексию");

            // Выводим значение поля name
            System.out.println("Имя: " + obj.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
