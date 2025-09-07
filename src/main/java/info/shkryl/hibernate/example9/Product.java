package info.shkryl.hibernate.example9;

import javax.persistence.*;

@Entity
@NamedQuery(
        name = "Product.findByCategory",
        query = "FROM Product WHERE category = :cat"
)
@NamedQuery(
        name = "Product.findByPriceRange",
        query = "FROM Product WHERE price BETWEEN :min AND :max"
)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String category;

    // Конструкторы, геттеры, сеттеры...

    public Product() {
    }

    public Product(Long id, String name, Double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}