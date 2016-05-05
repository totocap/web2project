package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@NamedQuery(name = "Team.findAll", query = "SELECT c FROM Team c")
@Table(name = Team.tableName)
public class Team implements Serializable {
	private static final long serialVersionUID = 6L;

	public static final String tableName = "Team";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@XmlElement
	@NotNull
	@Size(min = 1, max = 7)
	@OneToMany(mappedBy = "team", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH })
	private List<Membre> membre;

	public Team() {
		super();
		membre = new ArrayList<Membre>();
	}

	public void addMember(Membre membre) {
		membre.setTeam(this);
		this.membre.add(membre);
	}

	public List<Membre> getMembre() {
		return membre;
	}

	public void setMembres(ArrayList<Membre> membre) {
		this.membre = membre;
	}

	@Override
	public String toString() {
		String chaine = "";
		for (int cpt = 0; cpt < membre.size(); cpt++) {
			chaine += membre.get(cpt);
			chaine += "";
		}
		return chaine.toString();
	}

}
