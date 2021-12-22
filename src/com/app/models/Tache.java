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
@Table(name = "tache")
public class Tache implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refTache;
	@Column
	private String libelleTache;
	@ManyToMany
	@JoinTable(name = "Assume", joinColumns = @JoinColumn(name = "refTache"), inverseJoinColumns = @JoinColumn(name = "refPoste"))
	List<Poste> posts = new ArrayList<Poste>();

	public Tache() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tache [refTache=" + refTache + ", libelleTache=" + libelleTache + "]";
	}

	public Tache(int refTache, String libelleTache) {
		super();
		this.refTache = refTache;
		this.libelleTache = libelleTache;
	}

	public int getRefTache() {
		return refTache;
	}

	public void setRefTache(int refTache) {
		this.refTache = refTache;
	}

	public String getLibelleTache() {
		return libelleTache;
	}

	public void setLibelleTache(String libelleTache) {
		this.libelleTache = libelleTache;
	}

	public List<Poste> getPosts() {
		return posts;
	}

	public void setPosts(List<Poste> posts) {
		this.posts = posts;
	}

}
