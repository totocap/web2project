package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="client")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
@Table(name = Client.tableName)
public class Client implements Serializable{
	private static final long serialVersionUID = 3L;
	
	public static final String tableName = "Client";
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	 @XmlElement
	 @Column(name = "entity")
	  private String entity; 
	 
	 @XmlElement
	 @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH })
	  private Contact contact; 
	 
	 @XmlElement
	 @Column(name = "codePostal")
	  private String codePostal; 
		 
 	 public Client(String entity,Contact contact,String codePostal){
		 super();
		 this.entity = entity;
		 this.contact = contact;
		 this.codePostal = codePostal;
	 }
	 	 	 
	 public Client(){
	 }
	 	 
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	@Override
	 public String toString(){
		 return "Client :\n entity : " + entity + ",\n " + contact + " \n code Postal: " + codePostal; 
	 }
	 
}
