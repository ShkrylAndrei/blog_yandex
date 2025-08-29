package info.shkryl.hibernate.example5;

import jakarta.persistence.*;

@Entity
public class UserOfSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // ← ключевое!
    @JoinColumn(name = "profile_id")
    private UserProfile profile;

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

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "UserOfSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile=" + profile +
                '}';
    }
}
