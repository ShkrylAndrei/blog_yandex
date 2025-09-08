package info.shkryl.springDataJpa.example1;

import info.shkryl.springDataJpa.example1.entity.UserBlog;
import info.shkryl.springDataJpa.example1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Сохраняем пользователей
        userRepository.save(new UserBlog("Анна", "anna@example.com"));
        userRepository.save(new UserBlog("Борис", "boris@example.com"));

        // Выводим всех
        userRepository.findAll().forEach(user ->
                System.out.println("User: " + user.getName() + " (" + user.getEmail() + ")")
        );
    }
}
