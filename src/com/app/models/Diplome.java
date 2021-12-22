package com.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diplome")
public class Diplome implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refDiplome;
	@Column
	private String intituleDiplome;
	@ManyToMany(mappedBy = "diplomes")
	List<Profil> profils = new ArrayList<Profil>();

	public Diplome() {
		// TODO Auto-generated constructor stub
	}

	public int getRefDiplome() {
		return refDiplome;
	}

	public void setRefDiplome(int refDiplome) {
		this.refDiplome = refDiplome;
	}

	public String getIntituleDiplome() {
		return intituleDiplome;
	}

	public void setIntituleDiplome(String intituleDiplome) {
		this.intituleDiplome = intituleDiplome;
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	@Override
	public String toString() {
		return "Diplome [refDiplome=" + refDiplome + ", intituleDiplome=" + intituleDiplome + "]";
	}

	public Diplome(int refDiplome, String intituleDiplome) {
		super();
		this.refDiplome = refDiplome;
		this.intituleDiplome = intituleDiplome;
	}

}
