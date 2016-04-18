package fr.univ.rouen.david.web2project.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="membre")
@XmlAccessorType(XmlAccessType.NONE)

public class Membre implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@XmlAttribute
	  private boolean gender;
	
	 @XmlElement
	  private String nom; 
	 
	 @XmlElement
	  private String prenom; 
	 
	 	 public Membre(Boolean gender,String nom,String prenom){
		 super();
		 this.gender = gender;
		 this.nom = nom;
		 this.prenom = prenom;
		 }
	 	 
	 	 	 
	 public Membre(){
		 
	 }
	 
	 

	public boolean getGender() {
		return gender;
	}


	public void setGender(Boolean gender) {
		this.gender = gender;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	 public String toString(){
		 return "Membre [nom= " + nom + ", prenom=" + prenom + "]"; 
	 }
	 
}
