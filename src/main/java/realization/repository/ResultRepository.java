package realization.repository;

import realization.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import realization.model.User;


public interface ResultRepository extends JpaRepository<Result, Integer> {

    boolean existsResultByUser(User user);
}
