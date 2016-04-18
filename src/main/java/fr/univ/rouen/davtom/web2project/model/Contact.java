package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="contact")
@XmlAccessorType(XmlAccessType.NONE)

public class Contact implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@XmlAttribute
	  private boolean gender;
	
	 @XmlElement
	  private String nom; 
	 
	 @XmlElement
	  private String prenom; 
	 
	 	 public Contact(Boolean gender,String nom,String prenom){
		 super();
		 this.gender = gender;
		 this.nom = nom;
		 this.prenom = prenom;
		 }
	 	 
	 	 	 
	 public Contact(){
		 
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
		 return "Contact [nom= " + nom + ", prenom=" + prenom + "]"; 
	 }
	 
}
