package realization.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import realization.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BankRepository extends JpaRepository<Bank, Integer> {

    @Query(value = "SELECT * FROM bank ORDER BY rand(:userId) LIMIT 10 ", nativeQuery = true)
    List<Bank> questions(@Param("userId") Integer id);
}
