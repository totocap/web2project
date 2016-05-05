package fr.univ.rouen.davtom.web2project.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="stbs")
public class StbListVO {
		
	private List<StbModelVO> stbs;
	
	public StbListVO() {
		stbs = new ArrayList<StbModelVO>();
	}
	
	public List<StbModelVO> getStb(){
		return stbs;
	}
	
	public void setStb(List<StbModelVO> stb){
		this.stbs = stb;
	}



}
