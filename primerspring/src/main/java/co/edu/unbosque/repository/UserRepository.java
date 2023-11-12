package co.edu.unbosque.repository;

//Aqui van las operaciones personalizadas, el crud original ya existe

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByName(String name);

	public void deleteByName(String name);

}
