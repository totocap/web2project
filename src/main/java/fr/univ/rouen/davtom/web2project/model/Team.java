package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="team")
@XmlAccessorType(XmlAccessType.NONE)

public class Team implements Serializable{
	private static final long serialVersionUID = 6L;
	
	 @XmlElement
	  private ArrayList<Membre> membre;

	 
		 
 	 public Team(){
		super();
		membre = new ArrayList<Membre>();
	 }
	 	 
	 	 
	 
	 
	public void addMember(Membre membre){
		this.membre.add(membre);
	}

	public ArrayList<Membre> getMembre() {
		return membre;
	}


	public void setMembres(ArrayList<Membre> membre) {
		this.membre = membre;
	}


	@Override
	 public String toString(){
		String chaine = "";
		for(int cpt=0;cpt<membre.size();cpt++){
			chaine+=membre.get(cpt);
			chaine+="";
		}
		 return chaine.toString()   ; 
	 }
	 
}
