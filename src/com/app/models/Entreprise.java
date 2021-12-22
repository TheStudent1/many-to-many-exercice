package com.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entreprise")

public class Entreprise implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numAPE;
	@Column
	private String denomination;
	@Column
	private String adresse;
	@OneToMany(mappedBy = "entreprise")
	List<Poste> posts = new ArrayList<Poste>();

	public Entreprise() {
		// TODO Auto-generated constructor stub
	}

	public int getNumAPE() {
		return numAPE;
	}

	public void setNumAPE(int numAPE) {
		this.numAPE = numAPE;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adress) {
		this.adresse = adress;
	}

	public List<Poste> getPosts() {
		return posts;
	}

	public void setPosts(List<Poste> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Entreprise [numAPE=" + numAPE + ", denomination=" + denomination + ", adress=" + adresse + "]";
	}

	public Entreprise(int numAPE, String denomination, String adress) {
		super();
		this.numAPE = numAPE;
		this.denomination = denomination;
		this.adresse = adress;
	}

}
