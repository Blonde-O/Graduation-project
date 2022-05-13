package realization.repository;

import org.springframework.data.jpa.repository.Query;
import realization.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BankRepository extends JpaRepository<Bank, Integer> {
    @Query(value = "SELECT * FROM BANK ORDER BY rand() LIMIT 3 ", nativeQuery = true)
    List<Bank> questions();
}
