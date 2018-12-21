package banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import banque.model.Titulaire;
/**
 * @author tobelem
 */
public interface TitulaireRepository extends JpaRepository<Titulaire, Integer> {

}
