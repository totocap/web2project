package fr.univ.rouen.davtom.web2project.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="resume")
@XmlAccessorType(XmlAccessType.NONE)

public class Resume implements Serializable{
	private static final long serialVersionUID = 12L;

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
	 
	public Resume(Integer id, String title, double version, String date, String description) {
		super();
		this.id = id;
		this.title = title;
		this.version = version;
		this.date = date;
		this.description = description;
	} 
	
	public Resume(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Resume : id = " + id + ", "
				+ "title = " + title + ", "
				+ "version = " + version + ", "
				+ "date = " + date + ", \n"
				+ "description = "
				+ description + "]";
	}
	 
	
	 
	 
}
