package fr.univ.rouen.david.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="stb")
@XmlAccessorType(XmlAccessType.NONE)

public class StbModelVO implements Serializable{
	private static final long serialVersionUID = 2L;
	
	 @XmlAttribute
	  private Integer id;
	 
	 @XmlElement
	  private String title; 
	 
	 @XmlElement
	  private double version; 
	 
	 @XmlElement
	  private String date; 
	 
	 @XmlElement
	  private String description; 
	 
	 @XmlElement
	  private Client client; 
	 		 
	 @XmlElement
	  private Team team; 
	 
	 @XmlElement
	  private ArrayList<Fonctionnalite> fonctionnalite; 
	 
	 @XmlElement
	  private String commentaire; 
	 
	 
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
		 		 
	 }
	 
	 public StbModelVO(){
		 
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
		 return "StbModelVO [id=" + id + ", description=" + description + "]"; 
	 }
	 
}
