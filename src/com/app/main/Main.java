package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.models.Diplome;
import com.app.models.Poste;
import com.app.models.Profil;
import com.hibernate.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {

		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();

//		System.out.println("Posts per given Entreprise: ");
//
//		List<Poste> posts = s.getNamedQuery("postsPerOneEntreprise").setParameter("name", "NTT DATA").getResultList();
//
//		for (Poste p : posts) {
//			System.out.println("- - -");
//			System.out.println(p.toString());
//		}

//		System.out.println("Profil by Diplome:");
//
//		List<Object[]> profils = s.getNamedQuery("profilsPerDiplome").setParameter("nameDip", "Diplome2")
//				.getResultList();
//
//		for (Object[] pp : profils) {
//			System.out.println(pp[0]);
//		}
//
//		System.out.println("SUM Remuniration per Entreprise:");
//		List<Object[]> sums = s.getNamedQuery("sumRenumerationPerEnterprise").getResultList();
//
//		for (Object[] ss : sums) {
//			System.out.println(ss[0] + "---" + ss[1]);
//		}

//		System.out.println("All qualities per Post:");
//
//		List<Object[]> qualties = s.getNamedQuery("qualitiesPerPost").setParameter("namePost", "PST3").getResultList();
//
//		for (Object[] qq : qualties) {
//			System.out.println(qq[0]);
//		}

		System.out.println("Tache Per Diplome");

		List<Object[]> taches = s.getNamedQuery("tachePerDiplome").setParameter("nameDiplome", "Diplome1")
				.getResultList();

		for (Object[] tt : taches) {
			System.out.println(tt[0]);
		}

		s.close();
		// t.commit();

	}

}
