package com.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "poste")
@NamedQueries({
		@NamedQuery(name = "postsPerOneEntreprise", query = "from Poste p where p.entreprise.numAPE in (select e.numAPE from Entreprise e where e.denomination = :name )"),
		@NamedQuery(name = "sumRenumerationPerEnterprise", query = "select e.denomination, sum(p.remuneration) from Poste p inner join Entreprise e on p.entreprise.numAPE = e.numAPE group by e.denomination "),
		@NamedQuery(name = "qualitiesPerPost", query = "from Qualite q inner join q.profils pr inner join Poste p on pr.refProfil = p.profil.refProfil  where p.intitulePoste = :namePost"),
		@NamedQuery(name = "tachePerDiplome", query = "from Tache t inner join t.posts pst inner join Profil pr on pr.refProfil = pst.profil.refProfil inner join pr.diplomes dm where dm.intituleDiplome = :nameDiplome") })
public class Poste implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refPoste;
	@Column
	private String intitulePoste;
	@Column
	private Double remuneration;
	@ManyToMany(mappedBy = "posts")
	List<Tache> taches = new ArrayList<Tache>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "refProfil")
	private Profil profil;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "numAPE")
	private Entreprise entreprise;

	public int getRefPoste() {
		return refPoste;
	}

	public void setRefPoste(int refPoste) {
		this.refPoste = refPoste;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Double remuneration) {
		this.remuneration = remuneration;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Poste() {
		// TODO Auto-generated constructor stub
	}

	public Poste(int refPoste, String intitulePoste, Double remuniration) {
		super();
		this.refPoste = refPoste;
		this.intitulePoste = intitulePoste;
		this.remuneration = remuniration;
	}

	@Override
	public String toString() {
		return "Poste [refPoste=" + refPoste + ", intitulePoste=" + intitulePoste + ", remuneration=" + remuneration
				+ ", profil=" + profil.toString() + ", entreprise=" + entreprise.toString() + "]";
	}

}
