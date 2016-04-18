package fr.univ.rouen.davtom.web2project.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.davtom.web2project.model.Client;
import fr.univ.rouen.davtom.web2project.model.Contact;
import fr.univ.rouen.davtom.web2project.model.Exigence;
import fr.univ.rouen.davtom.web2project.model.Fonctionnalite;
import fr.univ.rouen.davtom.web2project.model.Membre;
import fr.univ.rouen.davtom.web2project.model.StbListVO;
import fr.univ.rouen.davtom.web2project.model.StbModelVO;
import fr.univ.rouen.davtom.web2project.model.Team;

@RestController
public class StbRESTController {

	 @RequestMapping(value = "/stbs")
	    public @ResponseBody StbListVO getAllStbs() 
	    {
	        StbListVO stbs = new StbListVO();
	        
	        // STB N°1
	        	// Fonctionnalités
	        	   ArrayList<Fonctionnalite> fonctStb1 = new ArrayList<Fonctionnalite>();
	        		// Exigence Fonctionnelle n°1
	        		Exigence exg1Fonct1Stb1 = new Exigence("e111", "première exigence", 2);
	        		Exigence exg2Fonct1Stb1 = new Exigence("e211", "seconde exigence", 5);
	        		ArrayList<Exigence> exgsFonct1Stb1 = new ArrayList<Exigence>();
	        		exgsFonct1Stb1.add(exg1Fonct1Stb1);
	        		exgsFonct1Stb1.add(exg2Fonct1Stb1);
	        		
	        		Fonctionnalite f1Stb1 = new Fonctionnalite(3, "Ajouter membre",exgsFonct1Stb1);
	        		fonctStb1.add(f1Stb1);
	        		// Exigence Fonctionnelle n°2
	        		Exigence exg1Fonct2Stb1 = new Exigence("e121", "première exigence", 1);
	        		Exigence exg2Fonct2Stb1 = new Exigence("e221", "seconde exigence", 2);
	        		ArrayList<Exigence> exgsFonct2Stb1 = new ArrayList<Exigence>();
	        		exgsFonct2Stb1.add(exg1Fonct2Stb1);
	        		exgsFonct2Stb1.add(exg2Fonct2Stb1);
	        		Fonctionnalite f2Stb1 = new Fonctionnalite(7, "Retirer membre",exgsFonct1Stb1);
	        		fonctStb1.add(f2Stb1);
	        		
	       		//Equipe composé de membres
	        Membre m1Stb1 = new Membre(true,"Doub","Steeve");
	        Membre m2Stb1 = new Membre(true,"Hill","Bill");
	        Team membreStb1 = new Team();
	        membreStb1.addMember(m1Stb1);
	        membreStb1.addMember(m2Stb1);
	        	// Client
	        Contact contact1 = new Contact(true,"Martin","Pierre"); 
	        Client client1 = new Client("Université de Rouen",contact1,"76000"); 
	        	
	        StbModelVO stb1 = new StbModelVO(1,"Stb n°1",1.0,"12/03/2016","Stb du groupe 1",
	        		client1,membreStb1,fonctStb1,"commentaire de la STB n°1");
	        
	        
	       // STB N°2
	     // Fonctionnalités
     	   ArrayList<Fonctionnalite> fonctStb2 = new ArrayList<Fonctionnalite>();
     		// Exigence Fonctionnelle n°1
     		Exigence exg1Fonct1Stb2 = new Exigence("e112", "première exigence", 8);
     		ArrayList<Exigence> exgsFonct1Stb2 = new ArrayList<Exigence>();
     		exgsFonct1Stb2.add(exg1Fonct1Stb2);
     		Fonctionnalite f1Stb2 = new Fonctionnalite(3, "Edition comptes utilisateurs ",exgsFonct1Stb2);
     		fonctStb2.add(f1Stb2);
     		// Exigence Fonctionnelle n°2
     		Exigence exg1Fonct2Stb2 = new Exigence("e122", "première exigence", 3);
     		Exigence exg2Fonct2Stb2 = new Exigence("e222", "seconde exigence", 4);
     		ArrayList<Exigence> exgsFonct2Stb2 = new ArrayList<Exigence>();
     		exgsFonct2Stb2.add(exg1Fonct2Stb2);
     		exgsFonct2Stb2.add(exg2Fonct2Stb2);
     		Fonctionnalite f2Stb2 = new Fonctionnalite(7, "Supression comptes utilisateurs",exgsFonct2Stb2);
     		fonctStb2.add(f2Stb2);
	        
	        Membre m1Stb2 = new Membre(true,"Dubois","Paul");
	        Membre m2Stb2 = new Membre(true,"Cany","Laurent");
	        Team membreStb2 = new Team();
	        membreStb2.addMember(m1Stb2);
	        membreStb2.addMember(m2Stb2);
	        Contact contact2 = new Contact(true,"Dupont","Robert"); 
	        Client client2 = new Client("Université de Caen",contact2,"14000");
	        StbModelVO stb2 = new StbModelVO(2,"Stb n°2",1.1,"15/03/2016","Stb du groupe 2",
	        		client2,membreStb2,fonctStb2,"commentaire de la STB n°2");
	       
	        
	        // STB N°3
	     // Fonctionnalités
     	   ArrayList<Fonctionnalite> fonctStb3 = new ArrayList<Fonctionnalite>();
     		// Exigence Fonctionnelle n°1
     		Exigence exg1Fonct1Stb3 = new Exigence("e113", "première exigence", 2);
     		Exigence exg2Fonct1Stb3 = new Exigence("e213", "seconde exigence", 5);
     		ArrayList<Exigence> exgsFonct1Stb3 = new ArrayList<Exigence>();
     		exgsFonct1Stb3.add(exg1Fonct1Stb3);
     		exgsFonct1Stb3.add(exg2Fonct1Stb3);
     		Fonctionnalite f1Stb3 = new Fonctionnalite(6, "Connexion site",exgsFonct1Stb3);
     		fonctStb3.add(f1Stb3);
     		// Exigence Fonctionnelle n°2
     		Exigence exg1Fonct2Stb3 = new Exigence("e123", "première exigence", 4);
     		Exigence exg2Fonct2Stb3 = new Exigence("e223", "seconde exigence", 6);
     		Exigence exg3Fonct2Stb3 = new Exigence("e323", "seconde exigence", 8);     		
     		ArrayList<Exigence> exgsFonct2Stb3 = new ArrayList<Exigence>();
     		exgsFonct2Stb3.add(exg1Fonct2Stb3);
     		exgsFonct2Stb3.add(exg2Fonct2Stb3);
     		exgsFonct2Stb3.add(exg3Fonct2Stb3);
     		Fonctionnalite f2Stb3 = new Fonctionnalite(9, "Deconnexion site",exgsFonct2Stb3);
     		fonctStb3.add(f2Stb3);
	        
	        Membre m1Stb3 = new Membre(false,"Helly","laura");
	        Team membreStb3 = new Team();
	        membreStb3.addMember(m1Stb3);
	        Contact contact3 = new Contact(false,"Henri","Marie"); 
	        Client client3 = new Client("Université de Toulouse",contact3,"31000");
	        StbModelVO stb3 = new StbModelVO(3,"Stb n°3",2.0,"17/03/2016","Stb du groupe 3",
	       	client3,membreStb3,fonctStb3,"commentaire de la STB n°3");
	         	        
	        stbs.getStb().add(stb1);
	        stbs.getStb().add(stb2);
	        stbs.getStb().add(stb3);
	         
	        return stbs;
	    }
	
	  @RequestMapping(value = "/stbs/{id}")
	    @ResponseBody
	    public ResponseEntity<StbModelVO> getStbById (@PathVariable("id") int id) 
	    {
	        if (id == 1) {
	        
	             // STB N°1
	        	// Fonctionnalités
	        	   ArrayList<Fonctionnalite> fonctStb1 = new ArrayList<Fonctionnalite>();
	        		// Exigence Fonctionnelle n°1
	        		Exigence exg1Fonct1Stb1 = new Exigence("e111", "première exigence", 2);
	        		Exigence exg2Fonct1Stb1 = new Exigence("e211", "seconde exigence", 5);
	        		ArrayList<Exigence> exgsFonct1Stb1 = new ArrayList<Exigence>();
	        		exgsFonct1Stb1.add(exg1Fonct1Stb1);
	        		exgsFonct1Stb1.add(exg2Fonct1Stb1);
	        		
	        		Fonctionnalite f1Stb1 = new Fonctionnalite(3, "Ajouter membre",exgsFonct1Stb1);
	        		fonctStb1.add(f1Stb1);
	        		// Exigence Fonctionnelle n°2
	        		Exigence exg1Fonct2Stb1 = new Exigence("e121", "première exigence", 1);
	        		Exigence exg2Fonct2Stb1 = new Exigence("e221", "seconde exigence", 2);
	        		ArrayList<Exigence> exgsFonct2Stb1 = new ArrayList<Exigence>();
	        		exgsFonct2Stb1.add(exg1Fonct2Stb1);
	        		exgsFonct2Stb1.add(exg2Fonct2Stb1);
	        		Fonctionnalite f2Stb1 = new Fonctionnalite(7, "Retirer membre",exgsFonct1Stb1);
	        		fonctStb1.add(f2Stb1);
	        		
	       		//Equipe composé de membres
	        Membre m1Stb1 = new Membre(true,"Doub","Steeve");
	        Membre m2Stb1 = new Membre(true,"Hill","Bill");
	        Team membreStb1 = new Team();
	        membreStb1.addMember(m1Stb1);
	        membreStb1.addMember(m2Stb1);
	        	// Client
	        Contact contact1 = new Contact(true,"Martin","Pierre"); 
	        Client client1 = new Client("Université de Rouen",contact1,"76000"); 
	        	
	        StbModelVO stb1 = new StbModelVO(1,"Stb n°1",1.0,"12/03/2016","Stb du groupe 1",
	        		client1,membreStb1,fonctStb1,"commentaire de la STB n°1");
	        
	            
	            
	            
	            return new ResponseEntity<StbModelVO>(stb1, HttpStatus.OK);
	            
	        }
	        return new ResponseEntity(HttpStatus.NOT_FOUND);
	    }
	 
}
