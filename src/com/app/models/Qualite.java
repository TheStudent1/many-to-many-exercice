package com.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "qualite")
public class Qualite implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refQualite;
	@Column
	private String intituleQualite;
	@ManyToMany(mappedBy = "qualites")
	List<Profil> profils = new ArrayList<Profil>();

	public Qualite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Qualite [refQualite=" + refQualite + ", intituleQualite=" + intituleQualite + "]";
	}

	public Qualite(int refQualite, String intituleQualite) {
		super();
		this.refQualite = refQualite;
		this.intituleQualite = intituleQualite;
	}

	public int getRefQualite() {
		return refQualite;
	}

	public void setRefQualite(int refQualite) {
		this.refQualite = refQualite;
	}

	public String getIntituleQualite() {
		return intituleQualite;
	}

	public void setIntituleQualite(String intituleQualite) {
		this.intituleQualite = intituleQualite;
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

}
