package banque.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * Titulaire
 * 
 */
@Entity
@Table(name="titulaire")
@NamedQuery(name="Titulaire.findAll", query="SELECT t FROM Titulaire t")
public class Titulaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int codetitulaire;

	@Column(length=32)
	private String adressetitulaire;

	@Column(length=5)
	private String codepostaltitulaire;

	@Column(nullable=false, length=32)
	private String nomtitulaire;

	@Column(nullable=false, length=32)
	private String prenomtitulaire;

	//bi-directional many-to-one association to Compte
	@OneToMany(mappedBy="titulaire", fetch=FetchType.EAGER)
//	@JsonManagedReference
	private List<Compte> comptes;

	public Titulaire() {
	}

	public int getCodetitulaire() {
		return this.codetitulaire;
	}

	public void setCodetitulaire(int codetitulaire) {
		this.codetitulaire = codetitulaire;
	}

	public String getAdressetitulaire() {
		return this.adressetitulaire;
	}

	public void setAdressetitulaire(String adressetitulaire) {
		this.adressetitulaire = adressetitulaire;
	}

	public String getCodepostaltitulaire() {
		return this.codepostaltitulaire;
	}

	public void setCodepostaltitulaire(String codepostaltitulaire) {
		this.codepostaltitulaire = codepostaltitulaire;
	}

	public String getNomtitulaire() {
		return this.nomtitulaire;
	}

	public void setNomtitulaire(String nomtitulaire) {
		this.nomtitulaire = nomtitulaire;
	}

	public String getPrenomtitulaire() {
		return this.prenomtitulaire;
	}

	public void setPrenomtitulaire(String prenomtitulaire) {
		this.prenomtitulaire = prenomtitulaire;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Compte addCompte(Compte compte) {
		getComptes().add(compte);
		compte.setTitulaire(this);

		return compte;
	}

	public Compte removeCompte(Compte compte) {
		getComptes().remove(compte);
		compte.setTitulaire(null);

		return compte;
	}

}