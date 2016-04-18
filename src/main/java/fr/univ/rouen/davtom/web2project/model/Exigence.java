package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="exigence")
@XmlAccessorType(XmlAccessType.NONE)

public class Exigence implements Serializable{
	private static final long serialVersionUID = 4L;
	
	 @XmlElement
	  private String identifiant; 
	 
	 @XmlElement
	  private String description; 
	 
	 @XmlElement
	  private int priorite; 
	 
	 	 public Exigence(String identifiant,String description,int priorite){
		 super();
		 this.identifiant = identifiant;
		 this.description = description;
		 this.priorite = priorite;
		 }
	 	 
	 	 	 
	 public Exigence(){
		 
	 }
	 
	
	@Override
	 public String toString(){
		 return "Exigence [identifiant= " + identifiant + ", description=" + description +
				 ", priorite= " + priorite + "]"; 
	 }
	 
}
