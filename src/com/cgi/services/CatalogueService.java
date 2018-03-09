package com.cgi.services;


import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cgi.metier.ICatalogueMetierImpl;
import com.cgi.model.Categorie;
import com.cgi.model.Produit;

@Singleton
@Path("/catalogue")
@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")	
public class CatalogueService {
	
	private ICatalogueMetierImpl metier;
	
	public CatalogueService() {
		
		metier= new ICatalogueMetierImpl();
		metier.initialiserCatalogue();
	}
	
	@GET
	@Path("/categories")
	public List<Categorie> consulterCategories(){
		
		return metier.listCategories();
	}
	
	@GET
	@Path("/categories/{idCategorie}/produits")
	public List<Produit>  produitsParCat(@PathParam(value="idCategorie") Long idCategorie){
		
		return metier.produitParCategorie(idCategorie);
	}
	
	@GET
	@Path("/produits")
	public List<Produit> produitsParMC(@QueryParam(value="mc")String mc){
		
		return metier.produitParMC(mc);
	}
	
	@POST
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	public Categorie  saveCategorie(Categorie categorie) {
		return metier.addCategorie(categorie);
	}
	
	@DELETE
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean deleteProduit(@FormParam(value = "idProduit") Long idProduit) {
		return metier.deleteProduit(idProduit);
	}
}
