package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;

@XmlRootElement (name="stb")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "StbModelVO.findAll", query = "SELECT c FROM StbModelVO c")
@Table(name = StbModelVO.tableName)
public class StbModelVO implements Serializable{
	private static final long serialVersionUID = 2L;
	
	public static final String tableName = "StbModelVO";
	
	
	@XmlAttribute
	private Integer id;
	
	@XmlElement
	private String title; 
	 
	@XmlElement
	@Range(min = 1, max = 3)
	private double version;
	 
	@XmlElement
	private String date;
	 
	@XmlElement
	private String description;
	 
	@XmlElement
	@NotNull
	@Valid
	private Client client;
	 
	@XmlElement
	@Valid
	private Team team;
	 
	@XmlElement
	@NotNull
	@Size(min = 1)
	@Valid
	private ArrayList<Fonctionnalite> fonctionnalite;
	 
	@XmlElement
	private String commentaire;
	 
	
	private Resume resume; 
	 
	 
	 public StbModelVO(Integer id,String title,double version,String date,
			 String description,Client client,Team team,
			 ArrayList<Fonctionnalite> fonctionnalite, String commentaire){
		 super();
		 this.id = id;
		 this.title = title;
		 this.version = version;
		 this.date = date;
		 this.description = description;
		 this.client = client;
		 this.team = team;
		 this.fonctionnalite = fonctionnalite;
		 this.commentaire = commentaire;
		 this.resume = new Resume(id,title,version,date,description);
	 }
	 
	 public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public StbModelVO(){
		 
	 }
	 	 
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ArrayList<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}

	public void setFonctionnalite(ArrayList<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getId() {
	        return id;
	    }
    public void setId(Integer id) {
	        this.id = id;
	    }
    public String getDescription() {
			return description;
		}

	public void setDescription(String description) {
			this.description = description;
		}

	@Override
	 public String toString(){
		 return "Stb Id : " + id + ",\n"
				 + "Title : " + title + ",\n"
				 + "Version : " + version + ",\n"
				 + "Date : " + date + ",\n"
				 + "Description : " + description + ",\n"
				 + "Client : " + client + ",\n"
				 + "Team : " + team + ",\n"
				 + "Fonctionnalités : " + fonctionnalite + ",\n"
				 + "Commentaire : " + commentaire;
	 } 
	 
}
