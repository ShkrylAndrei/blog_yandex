package info.shkryl.springPlusHibernate.example1;

import info.shkryl.springPlusHibernate.example1.config.AppConfig;
import info.shkryl.springPlusHibernate.example1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Загружаем контекст Spring
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем бин сервиса
        UserService userService = ctx.getBean(UserService.class);

        // Выполняем транзакционные операции
        userService.createUserAndList();
        userService.bulkInsert();

        // Закрываем контекст
        ctx.close();
    }
}
