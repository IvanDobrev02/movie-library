package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.Role;

@Repository
@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleName(String name);
}
