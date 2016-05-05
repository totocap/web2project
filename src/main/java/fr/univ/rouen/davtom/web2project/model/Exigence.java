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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exigence")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "Exigence.findAll", query = "SELECT c FROM Exigence c")
@Table(name = Exigence.tableName)
public class Exigence implements Serializable {
	private static final long serialVersionUID = 4L;

	public static final String tableName = "Exigence";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@XmlElement
	@Column(name = "identifiant")
	private String identifiant;

	@XmlElement
	@Column(name = "description")
	private String description;

	@XmlElement
	@Column(name = "priorite")
	private int priorite;

	@ManyToOne
	private Fonctionnalite fonctionnalite;

	public Exigence(String identifiant, String description, int priorite) {
		super();
		this.identifiant = identifiant;
		this.description = description;
		this.priorite = priorite;
	}

	public Exigence() {

	}

	public void setFonctionnalite(Fonctionnalite f) {
		fonctionnalite = f;
	}

	@Override
	public String toString() {
		return "Exigence \n identifiant :  " + identifiant + ", \n description : " + description + ", \n priorite : "
				+ priorite;
	}

}
