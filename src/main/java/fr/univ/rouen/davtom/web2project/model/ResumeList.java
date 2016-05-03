package fr.univ.rouen.davtom.web2project.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="resumes")
public class ResumeList {
	@XmlElement
	private List<Resume> resumes = new ArrayList<Resume>();
	
	public List<Resume> getResume(){
		return resumes;
	}
	
	public void setResume(List<Resume> resumes){
		this.resumes = resumes;
	}

}
