package info.shkryl.hibernate.example1;

import javax.persistence.*;

// Указывает, что этот класс — сущность (таблица в БД)
@Entity
@Table(name = "users") // имя таблицы
public class User {

    // Поле, которое будет первичным ключом
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоинкремент
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
