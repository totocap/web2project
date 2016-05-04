package fr.univ.rouen.davtom.web2project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.davtom.web2project.model.Client;
import fr.univ.rouen.davtom.web2project.model.Contact;
import fr.univ.rouen.davtom.web2project.model.Exigence;
import fr.univ.rouen.davtom.web2project.model.Fonctionnalite;
import fr.univ.rouen.davtom.web2project.model.Membre;
import fr.univ.rouen.davtom.web2project.model.ResumeList;
import fr.univ.rouen.davtom.web2project.model.StbListVO;
import fr.univ.rouen.davtom.web2project.model.StbModelVO;
import fr.univ.rouen.davtom.web2project.model.Team;

@RestController
public class StbRESTController {
	
	StbListVO stbs;
	ResumeList resumeList;
	ArrayList<Fonctionnalite> fonctStb1;
	Fonctionnalite f1Stb1;
	Exigence exg1Fonct1Stb1;
	Exigence exg2Fonct1Stb1;
	ArrayList<Exigence> exgsFonct1Stb1;
	Exigence exg1Fonct2Stb1;
	Exigence exg2Fonct2Stb1;
	ArrayList<Exigence> exgsFonct2Stb1;
	Fonctionnalite f2Stb1;
	Membre m1Stb1;
	Membre m2Stb1;
	Team membreStb1;
	Contact contact1;
	Client client1;
	StbModelVO stb1;
	 
	ArrayList<Fonctionnalite> fonctStb2;
	Exigence exg1Fonct1Stb2 ;
	ArrayList<Exigence> exgsFonct1Stb2;
	Fonctionnalite f1Stb2;
	Exigence exg1Fonct2Stb2;
	Exigence exg2Fonct2Stb2;
	ArrayList<Exigence> exgsFonct2Stb2;
	Fonctionnalite f2Stb2;
	Membre m1Stb2;
    Membre m2Stb2;
    Team membreStb2;
    Contact contact2; 
    Client client2 ;
    StbModelVO stb2;
    
    ArrayList<Fonctionnalite> fonctStb3 ;
	Exigence exg1Fonct1Stb3;
	Exigence exg2Fonct1Stb3;
	ArrayList<Exigence> exgsFonct1Stb3;
	Fonctionnalite f1Stb3;
	Exigence exg1Fonct2Stb3;
	Exigence exg2Fonct2Stb3;
	Exigence exg3Fonct2Stb3;     		
	ArrayList<Exigence> exgsFonct2Stb3;
	Fonctionnalite f2Stb3;
	Membre m1Stb3;
    Team membreStb3;
    Contact contact3; 
    Client client3;
    StbModelVO stb3;
    
   private void initialisation(){
	   stbs = new StbListVO();
	   resumeList = new ResumeList();
       
       // STB N°1
       	// Fonctionnalités
       	  fonctStb1 = new ArrayList<Fonctionnalite>();
       		// Exigence Fonctionnelle n°1
       		exg1Fonct1Stb1 = new Exigence("e111", "première exigence", 2);
       		exg2Fonct1Stb1 = new Exigence("e211", "seconde exigence", 5);
       		exgsFonct1Stb1 = new ArrayList<Exigence>();
       		exgsFonct1Stb1.add(exg1Fonct1Stb1);
       		exgsFonct1Stb1.add(exg2Fonct1Stb1);
       		
       		f1Stb1 = new Fonctionnalite(3, "Ajouter membre",exgsFonct1Stb1);
       		fonctStb1.add(f1Stb1);
       		// Exigence Fonctionnelle n°2
       		exg1Fonct2Stb1 = new Exigence("e121", "première exigence", 1);
       		exg2Fonct2Stb1 = new Exigence("e221", "seconde exigence", 2);
       		exgsFonct2Stb1 = new ArrayList<Exigence>();
       		exgsFonct2Stb1.add(exg1Fonct2Stb1);
       		exgsFonct2Stb1.add(exg2Fonct2Stb1);
       		f2Stb1 = new Fonctionnalite(7, "Retirer membre",exgsFonct1Stb1);
       		fonctStb1.add(f2Stb1);
       		
      		//Equipe composé de membres
      m1Stb1 = new Membre(true,"Doub","Steeve");
      m2Stb1 = new Membre(true,"Hill","Bill");
      membreStb1 = new Team();
      membreStb1.addMember(m1Stb1);
      membreStb1.addMember(m2Stb1);
       	// Client
       contact1 = new Contact(true,"Martin","Pierre"); 
       client1 = new Client("Université de Rouen",contact1,"76000"); 
       	
       stb1 = new StbModelVO(1,"Stb n°1",1.0,"12/03/2016","Stb du groupe 1",
       		client1,membreStb1,fonctStb1,"commentaire de la STB n°1");
       
       
      // STB N°2
    // Fonctionnalités
	   fonctStb2 = new ArrayList<Fonctionnalite>();
		// Exigence Fonctionnelle n°1
		exg1Fonct1Stb2 = new Exigence("e112", "première exigence", 8);
		exgsFonct1Stb2 = new ArrayList<Exigence>();
		exgsFonct1Stb2.add(exg1Fonct1Stb2);
		f1Stb2 = new Fonctionnalite(3, "Edition comptes utilisateurs ",exgsFonct1Stb2);
		fonctStb2.add(f1Stb2);
		// Exigence Fonctionnelle n°2
		exg1Fonct2Stb2 = new Exigence("e122", "première exigence", 3);
		exg2Fonct2Stb2 = new Exigence("e222", "seconde exigence", 4);
		exgsFonct2Stb2 = new ArrayList<Exigence>();
		exgsFonct2Stb2.add(exg1Fonct2Stb2);
		exgsFonct2Stb2.add(exg2Fonct2Stb2);
		f2Stb2 = new Fonctionnalite(7, "Supression comptes utilisateurs",exgsFonct2Stb2);
		fonctStb2.add(f2Stb2);
       
       m1Stb2 = new Membre(true,"Dubois","Paul");
       m2Stb2 = new Membre(true,"Cany","Laurent");
       membreStb2 = new Team();
       membreStb2.addMember(m1Stb2);
       membreStb2.addMember(m2Stb2);
       contact2 = new Contact(true,"Dupont","Robert"); 
       client2 = new Client("Université de Caen",contact2,"14000");
       stb2 = new StbModelVO(2,"Stb n°2",1.1,"15/03/2016","Stb du groupe 2",
       		client2,membreStb2,fonctStb2,"commentaire de la STB n°2");
      
       
       // STB N°3
    // Fonctionnalités
	   fonctStb3 = new ArrayList<Fonctionnalite>();
		// Exigence Fonctionnelle n°1
		 exg1Fonct1Stb3 = new Exigence("e113", "première exigence", 2);
		 exg2Fonct1Stb3 = new Exigence("e213", "seconde exigence", 5);
		 exgsFonct1Stb3 = new ArrayList<Exigence>();
		exgsFonct1Stb3.add(exg1Fonct1Stb3);
		exgsFonct1Stb3.add(exg2Fonct1Stb3);
		 f1Stb3 = new Fonctionnalite(6, "Connexion site",exgsFonct1Stb3);
		fonctStb3.add(f1Stb3);
		// Exigence Fonctionnelle n°2
		 exg1Fonct2Stb3 = new Exigence("e123", "première exigence", 4);
		 exg2Fonct2Stb3 = new Exigence("e223", "seconde exigence", 6);
		 exg3Fonct2Stb3 = new Exigence("e323", "seconde exigence", 8);     		
		 exgsFonct2Stb3 = new ArrayList<Exigence>();
		exgsFonct2Stb3.add(exg1Fonct2Stb3);
		exgsFonct2Stb3.add(exg2Fonct2Stb3);
		exgsFonct2Stb3.add(exg3Fonct2Stb3);
		 f2Stb3 = new Fonctionnalite(9, "Deconnexion site",exgsFonct2Stb3);
		fonctStb3.add(f2Stb3);
       
       m1Stb3 = new Membre(false,"Helly","laura");
       membreStb3 = new Team();
       membreStb3.addMember(m1Stb3);
       contact3 = new Contact(false,"Henri","Marie"); 
        client3 = new Client("Université de Toulouse",contact3,"31000");
       stb3 = new StbModelVO(3,"Stb n°3",2.0,"17/03/2016","Stb du groupe 3",
      	client3,membreStb3,fonctStb3,"commentaire de la STB n°3");
        	        
       stbs.getStb().add(stb1);
       stbs.getStb().add(stb2);
       stbs.getStb().add(stb3);
       
       resumeList.getResume().add(stb1.getResume());
       resumeList.getResume().add(stb2.getResume());
       resumeList.getResume().add(stb3.getResume());
       
       
   }
	
	
	
	
   private static Validator validator;
   
   public StbRESTController() {
	   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	   validator = factory.getValidator();
   }
   

	 @RequestMapping(value = "/stbs")
	    public @ResponseBody StbListVO getAllStbs() 
	    {
	       	initialisation();         
	        return stbs;
	    }
	 
	 @RequestMapping(value = "/resume")
	    public @ResponseBody ResumeList getAllStbresume() 
	    {
	       	initialisation();         
	        return resumeList;
	    }
	 
	 @RequestMapping(value = "/maxId")
	    public @ResponseBody ResponseEntity<Integer> getMaxID() 
	    {
	       	initialisation();
	       	int maxId = 0;
	       	for (StbModelVO stb : stbs.getStb()) {
	       		if (stb.getId() > maxId) {
	       			maxId = stb.getId();
	       		}
	       	}
	       	
	       	return new ResponseEntity<Integer>(maxId, HttpStatus.OK);
	    }
	
	  @RequestMapping(value = "/resume/{id}")
	    @ResponseBody
	    public ResponseEntity<StbModelVO> getStbById (@PathVariable("id") int id) 
	    {
		  initialisation();
	        if (id == 1) {
	               	            return new ResponseEntity<StbModelVO>(stb1, HttpStatus.OK);
	              }
	        if (id == 2) {
   	            return new ResponseEntity<StbModelVO>(stb2, HttpStatus.OK);
  }
	        if (id == 3) {
   	            return new ResponseEntity<StbModelVO>(stb3, HttpStatus.OK);
  }
	        return new ResponseEntity(HttpStatus.NOT_FOUND);
	    }
	  
	  
	 @RequestMapping(value = "/depot", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> postStb(@RequestBody StbModelVO stb) 
    {
		 Set<ConstraintViolation<StbModelVO>> constraintViolations =
			      validator.validate( stb );
		 if (constraintViolations.size() > 0) {
			 String s = "";
			 for(ConstraintViolation<StbModelVO> violation : constraintViolations) 
			 {
				 
			    s += violation.getPropertyPath().toString() + " " + violation.getMessage() + "\n";
			 }
			 return new ResponseEntity<String>(s, HttpStatus.OK);
		 }
		 
       	return new ResponseEntity<String>("Stb d'index " + stb.getId() + " ajoutee.", HttpStatus.CREATED);
    }
	 
}
