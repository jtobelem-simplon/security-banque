package banque.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * TypeCompte
 * 
 */
@Entity
@Table(name="typecompte")
//@NamedQuery(name="typecompte.findAll", query="SELECT t FROM typecompte t")
public class TypeCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=1)
	private String codetypecompte;

	@Column(nullable=false, length=25)
	private String intitulecompte;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="typecompte", fetch=FetchType.EAGER)
//	@JsonManagedReference
	private List<Compte> comptes;

	public TypeCompte() {
	}

	public String getCodetypecompte() {
		return this.codetypecompte;
	}

	public void setCodetypecompte(String codetypecompte) {
		this.codetypecompte = codetypecompte;
	}

	public String getIntitulecompte() {
		return this.intitulecompte;
	}

	public void setIntitulecompte(String intitulecompte) {
		this.intitulecompte = intitulecompte;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setTypecompte(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setTypecompte(null);

		return compte;
	}

}