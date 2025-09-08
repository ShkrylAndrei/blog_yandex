package info.shkryl.springDataJpa.example1.repository;


import info.shkryl.springDataJpa.example1.entity.UserBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserBlog, Long> {
    // Генерируется автоматически: SELECT * FROM users WHERE email = ?
    UserBlog findByEmail(String email);

    // SELECT * FROM users WHERE name LIKE %?%
    List<UserBlog> findByNameContaining(String substring);

    // SELECT * FROM users WHERE name LIKE ?% ORDER BY name ASC
    List<UserBlog> findByNameStartingWithOrderBynameAsc(String prefix);

    // Поддержка пагинации
    Page<UserBlog> findAll(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
    List<UserBlog> findByEmailDomain(@Param("domain") String domain);

    @Query(value = "SELECT * FROM users WHERE name LIKE %:name%", nativeQuery = true)
    List<UserBlog> searchByNameNative(@Param("name") String name);
}
