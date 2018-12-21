package banque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import banque.model.Compte;
import banque.model.Operation;
import banque.repository.CompteRepository;
import banque.repository.OperationRepository;
import banque.repository.TitulaireRepository;

/**
 * @author tobelem
 */
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private TitulaireRepository titulaireRepository;

	@RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> getOperationList(Model model) {
		List<Operation> operationList = operationRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(operationList);
	}


	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> getCompteList(Model model) {
		List<Compte> compteList = compteRepository.findAll();


		return ResponseEntity.status(HttpStatus.OK).body(compteList);
	}


	@RequestMapping(value = "/operationsByCompte/{numeroCompte}", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> getOperationList(@PathVariable Integer numeroCompte){
		Compte compte = new Compte();
		compte.setNumerocompte(numeroCompte);
		Iterable<Operation> operationIterable = operationRepository.findByCompte(compte);
		List<Operation> operationList = new ArrayList<>();
		operationIterable.forEach(operationList::add);
		return ResponseEntity.status(HttpStatus.OK).body(operationList);
	}
}
