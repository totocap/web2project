package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="fonctionnalite")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "Fonctionnalite.findAll", query = "SELECT c FROM Fonctionnalite c")
@Table(name = Fonctionnalite.tableName)
public class Fonctionnalite implements Serializable{
	private static final long serialVersionUID = 7L;
	
	public static final String tableName= "Fonctionnalite";
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@XmlAttribute
	@Min(1)
	@Max(10)
	@Column(name = "priorite")
	private int priorite;
	
	@XmlElement
	@Column(name = "description")
	private String description;
	
	@XmlElement
	@NotNull
	@Size(min = 2)
	@OneToMany(mappedBy="fonctionnalite", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH })
	private List<Exigence> exigence;
	
	@ManyToOne
	private StbModelVO stb;

	public Fonctionnalite(Integer priorite,String description,
			 List<Exigence> exigence){
		super();
		this.priorite = priorite;
		this.description = description;
		for (Exigence e : exigence) {
			e.setFonctionnalite(this);
		}
		this.exigence = exigence;
	}
	 
	 public Fonctionnalite(){
			
	}
	@Override
	 public String toString(){
		 return "Fonctionalite priorite : " + priorite + ",\n description : " + description +
				 ", \n exigence : " + exigence; 
	 }
	 
	
	public void setStb(StbModelVO s) {
		stb = s;
	}
}