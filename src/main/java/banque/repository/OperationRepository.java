package banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banque.model.Compte;
import banque.model.Operation;

/**
 * @author tobelem
 */
public interface OperationRepository extends JpaRepository<Operation, Integer>{
	Iterable<Operation> findByCompte(Compte compte);
}
