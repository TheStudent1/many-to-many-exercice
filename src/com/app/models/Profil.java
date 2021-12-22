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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profil")
@NamedQueries({
		@NamedQuery(name = "profilsPerDiplome", query = "from Profil p inner join p.diplomes d  where d.intituleDiplome =  :nameDip group by p.intituleProfil") })
public class Profil implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refProfil;
	@Column
	private String intituleProfil;
	@Column
	private String niveauScolaire;
	@Column
	private String experienceProfil;
	@OneToMany(mappedBy = "profil")
	List<Poste> posts = new ArrayList<Poste>();
	@ManyToMany
	@JoinTable(name = "ExigerQ", joinColumns = @JoinColumn(name = "refProfil"), inverseJoinColumns = @JoinColumn(name = "refQualite"))
	List<Qualite> qualites = new ArrayList<Qualite>();
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ExigerD", joinColumns = @JoinColumn(name = "refProfil"), inverseJoinColumns = @JoinColumn(name = "refDiplome"))
	List<Diplome> diplomes = new ArrayList<Diplome>();

	public Profil() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profil [refProfil=" + refProfil + ", intituleProfil=" + intituleProfil + ", niveauScolaire="
				+ niveauScolaire + ", experienceProfil=" + experienceProfil + "]";
	}

	public int getRefProfil() {
		return refProfil;
	}

	public void setRefProfil(int refProfil) {
		this.refProfil = refProfil;
	}

	public String getIntituleProfil() {
		return intituleProfil;
	}

	public void setIntituleProfil(String intituleProfil) {
		this.intituleProfil = intituleProfil;
	}

	public String getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(String niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

	public String getExperienceProfil() {
		return experienceProfil;
	}

	public void setExperienceProfil(String experienceProfil) {
		this.experienceProfil = experienceProfil;
	}

	public List<Poste> getPosts() {
		return posts;
	}

	public void setPosts(List<Poste> posts) {
		this.posts = posts;
	}

	public List<Qualite> getQualites() {
		return qualites;
	}

	public void setQualites(List<Qualite> qualites) {
		this.qualites = qualites;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public Profil(int refProfil, String intituleProfil, String niveauScolaire, String experienceProfil) {
		super();
		this.refProfil = refProfil;
		this.intituleProfil = intituleProfil;
		this.niveauScolaire = niveauScolaire;
		this.experienceProfil = experienceProfil;
	}

}
