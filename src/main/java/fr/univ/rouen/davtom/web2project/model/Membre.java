package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="membre")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "Membre.findAll", query = "SELECT c FROM Membre c")
@Table(name = Membre.tableName)
public class Membre implements Serializable{
	private static final long serialVersionUID = 4L;
	
	public static final String tableName = "Membre";
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@XmlAttribute
	@Column(name = "GENDER")
	  private boolean gender;
	
	 @XmlElement
	 @Column(name = "NOM")
	  private String nom; 
	 
	 @XmlElement
	 @Column(name = "PRENOM")
	  private String prenom; 
	 
	 @ManyToOne
	 private Team team;
	 
	 	 public Membre(Boolean gender,String nom,String prenom){
		 super();
		 this.gender = gender;
		 this.nom = nom;
		 this.prenom = prenom;
		 }
	 	 
	 	 	 
	 public Membre(){
		 
	 }
	 
	 
	public void setTeam(Team t) {
		team = t;
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
		 return " Membre nom : " + nom + ", \n prenom : " + prenom; 
	 }
	 
}
