package fr.univ.rouen.davtom.web2project.service;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Allows the connection to the database.
 */
public class EntityManagerConnectionService {

	private static String path;
	private static EntityManager em;

	/**
	 * @return an instance of EntityManager
	 */
	public static EntityManager getInstance() {
		if (em == null) {
			try {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory(getPersistanceName());
				em = emf.createEntityManager();
			} catch (Exception e) {
				System.err.println("Erreur de connexion à la base de données.");
				System.err.println(e.getMessage());
			}
		}
		
		return em;
	}
	

	private static String getPersistanceName() {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File(path));
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("persistence-unit");
			Node nNode = nList.item(0);
			Element eElement = (Element) nNode;
			return eElement.getAttribute("name");
		} catch (Exception e) {
			return e.toString();

		}
	}


	public static String getPath() {
		return path;
	}

	/**
	 * Sets the path to persistence XML file.
	 */
	public static void setPath(String p) {
		path = p;
	}
}
