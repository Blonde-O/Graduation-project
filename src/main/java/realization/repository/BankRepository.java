package realization.repository;

import realization.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface BankRepository extends JpaRepository<Bank, Integer> {
}
