package fr.univ.rouen.davtom.web2project.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="resumes")
public class ResumeList {
private List<Resume> resumes;

	public ResumeList() {
		resumes = new ArrayList<Resume>();
	}
	
	public List<Resume> getResume(){
		return resumes;
	}
	
	public void addResume(Resume resume){
		this.resumes.add(resume);
	}
	
	public void setResume(List<Resume> resume){
		this.resumes = resume;
	}

}
