package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.experimentos.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
