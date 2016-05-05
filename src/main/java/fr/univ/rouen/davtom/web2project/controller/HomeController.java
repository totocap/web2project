package fr.univ.rouen.davtom.web2project.controller;

import java.sql.SQLException;

import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.univ.rouen.davtom.web2project.service.EntityManagerConnectionService;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) throws SQLException {
		EntityManagerConnectionService.getInstance().getTransaction().begin();
		Query query = EntityManagerConnectionService.getInstance().createQuery("SELECT COUNT(s) FROM StbModelVO s");
		Long count = (Long) query.getSingleResult();
		EntityManagerConnectionService.getInstance().getTransaction().commit();

		model.addAttribute("count", count);
		return "hello";

	}
}
