package banque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * Operation
 * 
 */
@Entity
@Table(name="operations")
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int numerooperation;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateoperation;

	@Column(nullable=false, length=32)
	private String libelleoperation;

	@Column(nullable=false)
	private float montant;

	@Column(nullable=false, length=1)
	private String typeoperation;

	//bi-directionelle many-to-one association vers Compte
	@ManyToOne
	@JoinColumn(name="NUMEROCOMPTE", nullable=false)
//	@JsonBackReference
	private Compte compte;

	public Operation() {
	}

	public int getNumerooperation() {
		return this.numerooperation;
	}

	public void setNumerooperation(int numerooperation) {
		this.numerooperation = numerooperation;
	}

	public Date getDateoperation() {
		return this.dateoperation;
	}

	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}

	public String getLibelleoperation() {
		return this.libelleoperation;
	}

	public void setLibelleoperation(String libelleoperation) {
		this.libelleoperation = libelleoperation;
	}

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getTypeoperation() {
		return this.typeoperation;
	}

	public void setTypeoperation(String typeoperation) {
		this.typeoperation = typeoperation;
	}

	public Compte getCompte() {
		return this.compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}