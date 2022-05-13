package realization.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import realization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

   /*@EntityGraph(value = "User.role")*/
    Optional<User> findByLogin (String login);
    User findUserByLogin (String login);
}

