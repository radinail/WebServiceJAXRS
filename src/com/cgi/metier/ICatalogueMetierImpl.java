package com.cgi.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cgi.model.Categorie;
import com.cgi.model.Produit;


public class ICatalogueMetierImpl implements ICatalogueMetier {
	
	private Map<Long, Categorie> categories = new HashMap<Long, Categorie>();
	private Map<Long, Produit> produits = new HashMap<Long, Produit>();
	
	public Categorie addCategorie(Categorie categorie) {
		
		categories.put(categorie.getIdCategorie(), categorie);		
		return categorie;
	}
	
	public Produit addProduit(Produit produit) {
		
		produit.setCategorie(produit.getCategorie());
		produits.put(produit.getIdProduit(), produit);
		return  produit;
		
	}
	
	public List<Categorie> listCategories(){
		
		return new ArrayList<Categorie>(categories.values());
	}
	
	public List<Produit> produitParCategorie(Long idCategorie){
		
		List<Produit> prods = new ArrayList<Produit>();
		for(Produit p :  produits.values()) 
			if(p.getCategorie().getIdCategorie().equals(idCategorie))
				prods.add(p);
		
		return prods;
	}
	
	public List<Produit> listProduit(){
		
		return new ArrayList<Produit>(produits.values());
	}
	
	public List<Produit> produitParMC(String mc){
		
		List<Produit> prods = new ArrayList<Produit>();
		for(Produit p :  produits.values()) 
			if(p.getDesignation().contains(mc))
				prods.add(p);
		
		return prods;
	}
	
	public Categorie updateCategorie(Categorie categorie) {
		
		categories.put(categorie.getIdCategorie(), categorie);
		return categorie;
	}
	
	public boolean deleteProduit(Long idProduit) {
		
		if(produits.get(idProduit) != null) {
			produits.remove(idProduit);
			return true;
		}
		
		else throw new RuntimeException("Produit introuvable");
	}
	
	public Produit updateProduit(Produit produit) {
		
		produits.put(produit.getIdProduit(), produit);
		return produit;
	}
	
	public void initialiserCatalogue() {
		
		addCategorie(new Categorie(1L, "Ordi", "Ordi.jpg"));
		addCategorie(new Categorie(2L, "Imprimante", "Imprimante.jpg"));
		addCategorie(new Categorie(3L, "Téléphone", "Téléphone.jpg"));
		
		produits.put(1L, new Produit(1L, "HP", 6500, "Ordi1.jpg", categories.get(1L)));
		produits.put(1L, new Produit(2L, "Asus", 4500, "Ordi2.jpg", categories.get(2L)));
		produits.put(1L, new Produit(1L, "MAC", 7800, "Ordi3.jpg", categories.get(3L)));
		
	}

}
