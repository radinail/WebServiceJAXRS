package com.cgi.metier;

import java.util.List;

import com.cgi.model.Categorie;
import com.cgi.model.Produit;

public interface ICatalogueMetier {
	
	public Categorie addCategorie(Categorie categorie);
	public Produit addProduit(Produit produit);
	public List<Categorie> listCategories();
	public List<Produit> produitParCategorie(Long idCategorie);
	public List<Produit> listProduit();
	public List<Produit> produitParMC(String mc);
	public Categorie updateCategorie(Categorie categorie);
	public boolean deleteProduit(Long idProduit);
	public Produit updateProduit(Produit produit);
	
	
}
