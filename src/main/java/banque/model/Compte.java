package banque.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * Compte
 * 
 */
@Entity
@Table(name="compte")
@NamedQuery(name="Compte.findAll", query="SELECT c FROM Compte c")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property= "numerocompte")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int numerocompte;

	@Column(nullable=false)
	private float soldecompte;

	//bi-directionelle many-to-one association vers TypeCompte
	@ManyToOne
	@JoinColumn(name="CODETYPECOMPTE", nullable=false)
	@JsonIgnore

	private TypeCompte typecompte;

	//bi-directionelle many-to-one association vers Titulaire
	@ManyToOne
	@JoinColumn(name="CODETITULAIRE", nullable=false)
//	@JsonBackReference
	@JsonIgnore

	private Titulaire titulaire;

	//bi-directionelle many-to-one association vers Operation
	@OneToMany(mappedBy="compte", fetch=FetchType.EAGER)
//	@JsonManagedReference
	@JsonIgnore
	private List<Operation> operations;

	public Compte() {
	}

	public int getNumerocompte() {
		return this.numerocompte;
	}

	public void setNumerocompte(int numerocompte) {
		this.numerocompte = numerocompte;
	}

	public float getSoldecompte() {
		return this.soldecompte;
	}

	public void setSoldecompte(float soldecompte) {
		this.soldecompte = soldecompte;
	}

	public TypeCompte getTypecompte() {
		return this.typecompte;
	}

	public void setTypecompte(TypeCompte typeCompte) {
		this.typecompte = typeCompte;
	}

	public Titulaire getTitulaire() {
		return this.titulaire;
	}

	public void setTitulaire(Titulaire titulaire) {
		this.titulaire = titulaire;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Operation addOperation(Operation operation) {
		getOperations().add(operation);
		operation.setCompte(this);

		return operation;
	}

	public Operation removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setCompte(null);

		return operation;
	}

	@Override
	public String toString() {
		return "Compte [numerocompte=" + numerocompte + ", soldecompte=" + soldecompte + ", typecompte=" + typecompte
				+ ", titulaire=" + titulaire + ", operations=" + operations + "]";
	}
	

}