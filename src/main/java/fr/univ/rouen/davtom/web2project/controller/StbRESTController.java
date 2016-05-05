package fr.univ.rouen.davtom.web2project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.davtom.web2project.model.Client;
import fr.univ.rouen.davtom.web2project.model.Contact;
import fr.univ.rouen.davtom.web2project.model.Exigence;
import fr.univ.rouen.davtom.web2project.model.Fonctionnalite;
import fr.univ.rouen.davtom.web2project.model.Membre;
import fr.univ.rouen.davtom.web2project.model.ResumeList;
import fr.univ.rouen.davtom.web2project.model.StbListVO;
import fr.univ.rouen.davtom.web2project.model.StbModelVO;
import fr.univ.rouen.davtom.web2project.model.Team;
import fr.univ.rouen.davtom.web2project.service.EntityManagerConnectionService;

@RestController
public class StbRESTController {
	private List<StbModelVO> stbs;
	private static Validator validator;

	public StbRESTController() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		// Persistence
		EntityManagerConnectionService
				.setPath(this.getClass().getClassLoader().getResource("META-INF/persistence.xml").getPath());
		EntityManagerConnectionService.getInstance();

		stbs = new ArrayList<StbModelVO>();
		createStb();
		saveStb(1);
		saveStb(2);
		saveStb(3);
	}

	@RequestMapping(value = "/stbs")
	public @ResponseBody ResponseEntity<StbListVO> getAllStbs() {
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			Query query = EntityManagerConnectionService.getInstance().createQuery("SELECT s FROM StbModelVO s");
			List<StbModelVO> stbs = (List<StbModelVO>) query.getResultList();
			StbListVO stbList = new StbListVO();
			stbList.setStb(stbs);
			EntityManagerConnectionService.getInstance().getTransaction().commit();
			return new ResponseEntity<StbListVO>(stbList, HttpStatus.OK);
		} catch (Exception e) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
			return new ResponseEntity<StbListVO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/resume")
	public @ResponseBody ResponseEntity<ResumeList> getAllStbresume() {
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			Query query = EntityManagerConnectionService.getInstance().createQuery("SELECT s FROM StbModelVO s");
			List<StbModelVO> stbs = (List<StbModelVO>) query.getResultList();
			ResumeList rL = new ResumeList();
			for (StbModelVO stb : stbs) {
				rL.addResume(stb.getResume());
			}
			EntityManagerConnectionService.getInstance().getTransaction().commit();
			return new ResponseEntity<ResumeList>(rL, HttpStatus.OK);
		} catch (Exception e) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
			return new ResponseEntity<ResumeList>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/maxId")
	public @ResponseBody ResponseEntity<Integer> getMaxID() {
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			Query query = EntityManagerConnectionService.getInstance()
					.createQuery("SELECT MAX(s.id) FROM StbModelVO s");
			Integer maxId = (Integer) query.getSingleResult();
			EntityManagerConnectionService.getInstance().getTransaction().commit();
			return new ResponseEntity<Integer>(maxId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/resume/{id}")
	@ResponseBody
	public ResponseEntity<StbModelVO> getStbById(@PathVariable("id") int id) {
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			Query query = EntityManagerConnectionService.getInstance()
					.createQuery("SELECT s FROM StbModelVO s WHERE s.id = :id");
			query.setParameter("id", id);
			StbModelVO stb = (StbModelVO) query.getSingleResult();
			EntityManagerConnectionService.getInstance().getTransaction().commit();
			return new ResponseEntity<StbModelVO>(stb, HttpStatus.OK);
		} catch (Exception e) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
			return new ResponseEntity<StbModelVO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> postStb(@RequestBody StbModelVO stb) {
		Set<ConstraintViolation<StbModelVO>> constraintViolations = validator.validate(stb);
		if (constraintViolations.size() > 0) {
			String s = "";
			for (ConstraintViolation<StbModelVO> violation : constraintViolations) {
				s += violation.getPropertyPath().toString() + " " + violation.getMessage() + "\n";
			}
			return new ResponseEntity<String>(s, HttpStatus.OK);
		}

		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			EntityManagerConnectionService.getInstance().persist(stb);
			EntityManagerConnectionService.getInstance().getTransaction().commit();
		} catch (Exception e1) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
		}

		return new ResponseEntity<String>("Stb d'index " + stb.getId() + " ajoutee.", HttpStatus.CREATED);
	}
	
	private void saveStb(int id) {
		Long res = -1L;
		try {
			EntityManagerConnectionService.getInstance().getTransaction().begin();
			Query query = EntityManagerConnectionService.getInstance()
					.createQuery("SELECT COUNT(s) FROM StbModelVO s WHERE s.id = :id");
			query.setParameter("id",  id);
			res = (Long) query.getSingleResult();
			EntityManagerConnectionService.getInstance().getTransaction().commit();
		} catch (Exception e) {
			EntityManagerConnectionService.getInstance().getTransaction().rollback();
		}
		

		if (res == 0) {
			try {
				EntityManagerConnectionService.getInstance().getTransaction().begin();
				EntityManagerConnectionService.getInstance().persist(stbs.get(id - 1));
				EntityManagerConnectionService.getInstance().getTransaction().commit();
			} catch (Exception e1) {
				EntityManagerConnectionService.getInstance().getTransaction().rollback();
			}
		}
	}

	private void createStb() {
		// STB N°1
		// Fonctionnalités
		List<Fonctionnalite> fonctStb1 = new ArrayList<Fonctionnalite>();
		// Exigence Fonctionnelle n°1
		Exigence exg1Fonct1Stb1 = new Exigence("e111", "première exigence", 2);
		Exigence exg2Fonct1Stb1 = new Exigence("e211", "seconde exigence", 5);
		List<Exigence> exgsFonct1Stb1 = new ArrayList<Exigence>();
		exgsFonct1Stb1.add(exg1Fonct1Stb1);
		exgsFonct1Stb1.add(exg2Fonct1Stb1);

		Fonctionnalite f1Stb1 = new Fonctionnalite(3, "Ajouter membre", exgsFonct1Stb1);
		fonctStb1.add(f1Stb1);
		// Exigence Fonctionnelle n°2
		Exigence exg1Fonct2Stb1 = new Exigence("e121", "première exigence", 1);
		Exigence exg2Fonct2Stb1 = new Exigence("e221", "seconde exigence", 2);
		List<Exigence> exgsFonct2Stb1 = new ArrayList<Exigence>();
		exgsFonct2Stb1.add(exg1Fonct2Stb1);
		exgsFonct2Stb1.add(exg2Fonct2Stb1);
		Fonctionnalite f2Stb1 = new Fonctionnalite(7, "Retirer membre", exgsFonct2Stb1);
		fonctStb1.add(f2Stb1);

		// Equipe composé de membres
		Membre m1Stb1 = new Membre(true, "Doub", "Steeve");
		Membre m2Stb1 = new Membre(true, "Hill", "Bill");
		Team membreStb1 = new Team();
		membreStb1.addMember(m1Stb1);
		membreStb1.addMember(m2Stb1);
		// Client
		Contact contact1 = new Contact(true, "Martin", "Pierre");
		Client client1 = new Client("Université de Rouen", contact1, "76000");

		stbs.add(new StbModelVO(1, "Stb n°1", 1.0, "12/03/2016", "Stb du groupe 1", client1, membreStb1, fonctStb1,
				"commentaire de la STB n°1"));

		// STB N°2
		// Fonctionnalités
		List<Fonctionnalite> fonctStb2 = new ArrayList<Fonctionnalite>();
		// Exigence Fonctionnelle n°2
		Exigence exg1Fonct2Stb2 = new Exigence("e122", "première exigence", 3);
		Exigence exg2Fonct2Stb2 = new Exigence("e222", "seconde exigence", 4);
		List<Exigence> exgsFonct2Stb2 = new ArrayList<Exigence>();
		exgsFonct2Stb2.add(exg1Fonct2Stb2);
		exgsFonct2Stb2.add(exg2Fonct2Stb2);
		Fonctionnalite f2Stb2 = new Fonctionnalite(7, "Supression comptes utilisateurs", exgsFonct2Stb2);
		fonctStb2.add(f2Stb2);

		Membre m1Stb2 = new Membre(true, "Dubois", "Paul");
		Membre m2Stb2 = new Membre(true, "Cany", "Laurent");
		Team membreStb2 = new Team();
		membreStb2.addMember(m1Stb2);
		membreStb2.addMember(m2Stb2);
		Contact contact2 = new Contact(true, "Dupont", "Robert");
		Client client2 = new Client("Université de Caen", contact2, "14000");
		stbs.add(new StbModelVO(2, "Stb n°2", 1.1, "15/03/2016", "Stb du groupe 2", client2, membreStb2, fonctStb2,
				"commentaire de la STB n°2"));

		// STB N°3
		// Fonctionnalités
		List<Fonctionnalite> fonctStb3 = new ArrayList<Fonctionnalite>();
		// Exigence Fonctionnelle n°1
		Exigence exg1Fonct1Stb3 = new Exigence("e113", "première exigence", 2);
		Exigence exg2Fonct1Stb3 = new Exigence("e213", "seconde exigence", 5);
		List<Exigence> exgsFonct1Stb3 = new ArrayList<Exigence>();
		exgsFonct1Stb3.add(exg1Fonct1Stb3);
		exgsFonct1Stb3.add(exg2Fonct1Stb3);
		Fonctionnalite f1Stb3 = new Fonctionnalite(6, "Connexion site", exgsFonct1Stb3);
		fonctStb3.add(f1Stb3);
		// Exigence Fonctionnelle n°2
		Exigence exg1Fonct2Stb3 = new Exigence("e123", "première exigence", 4);
		Exigence exg2Fonct2Stb3 = new Exigence("e223", "seconde exigence", 6);
		Exigence exg3Fonct2Stb3 = new Exigence("e323", "seconde exigence", 8);
		List<Exigence> exgsFonct2Stb3 = new ArrayList<Exigence>();
		exgsFonct2Stb3.add(exg1Fonct2Stb3);
		exgsFonct2Stb3.add(exg2Fonct2Stb3);
		exgsFonct2Stb3.add(exg3Fonct2Stb3);
		Fonctionnalite f2Stb3 = new Fonctionnalite(9, "Deconnexion site", exgsFonct2Stb3);
		fonctStb3.add(f2Stb3);

		Membre m1Stb3 = new Membre(false, "Helly", "laura");
		Team membreStb3 = new Team();
		membreStb3.addMember(m1Stb3);
		Contact contact3 = new Contact(false, "Henri", "Marie");
		Client client3 = new Client("Université de Toulouse", contact3, "31000");
		stbs.add(new StbModelVO(3, "Stb n°3", 2.0, "17/03/2016", "Stb du groupe 3", client3, membreStb3, fonctStb3,
				"commentaire de la STB n°3"));
	}
}
