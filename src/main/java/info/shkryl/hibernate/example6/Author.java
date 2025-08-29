package info.shkryl.hibernate.example6;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "author",           // поле в Book, которое ссылается на Author
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();
}