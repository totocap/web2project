package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="fonctionnalite")
@XmlAccessorType(XmlAccessType.NONE)

public class Fonctionnalite implements Serializable{
	private static final long serialVersionUID = 7L;
	
	@XmlAttribute
	  private Integer priorite;
	
	@XmlElement
	  private String description;
	
	@XmlElement
	  private ArrayList<Exigence> exigence;

	 public Fonctionnalite(Integer priorite,String description,
			 ArrayList<Exigence> exigence){
		super();
		this.priorite = priorite;
		this.description = description;
		this.exigence = exigence;
		 }
	 	 
	 	 
	 
	 public Fonctionnalite(){
			
			 }
	

	
	@Override
	 public String toString(){
		 return "Fonctionalites [priorite= " + priorite + ", description=" + description +
				 ", exigence= " + exigence + "]"; 
	 }
	 
}