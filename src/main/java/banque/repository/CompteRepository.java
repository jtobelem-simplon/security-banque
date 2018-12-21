package banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banque.model.Compte;
import banque.model.Titulaire;

/**
 * @author tobelem
 */
public interface CompteRepository extends JpaRepository<Compte, Integer>{
	public Iterable<Compte> findByTitulaire(Titulaire titulaire);
}
