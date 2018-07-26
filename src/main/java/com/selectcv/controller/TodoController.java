package com.selectcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.selectcv.model.Education;
import com.selectcv.model.Experience;
import com.selectcv.model.JobOffer;
import com.selectcv.model.Registration;
import com.selectcv.service.CountryService;
import com.selectcv.service.EducationService;
import com.selectcv.service.ExperienceService;
import com.selectcv.service.JobOfferService;
import com.selectcv.service.RegistrationService;

import java.sql.Timestamp;

@Controller
@ComponentScan
public class TodoController {

	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	private EducationService educationService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private JobOfferService jobOfferService;
	@Autowired
	private ExperienceService experienceService;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private GlobalController globalController;

	@RequestMapping("/education")
	public String login(Model model) {
		model.addAttribute("countryList", countryService.findAll());
		model.addAttribute("reqEducation", new Education());
		logger.info("education");
		return "education";
	}

	@RequestMapping(value = { "/education/save" }, method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("reqEducation") Education reqEducation,
			final RedirectAttributes redirectAttributes) {
		logger.info("/education/save");
		reqEducation.setUser(globalController.getLoginUser());
		educationService.save(reqEducation);
		return "redirect:/home";
	}

	@RequestMapping("/experience")
	public String experience(Model model) {
		// model.addAttribute("countryList", countryService.findAll());
		model.addAttribute("reqExperience", new Experience());
		logger.info("experience");
		return "experience";
	}

	@RequestMapping(value = { "/experience/save" }, method = RequestMethod.POST)
	public String saveExperience(@ModelAttribute("reqExperience") Experience reqExperience,
			final RedirectAttributes redirectAttributes) {
		logger.info("/experience/save");
		reqExperience.setUser(globalController.getLoginUser());
		experienceService.save(reqExperience);
		return "redirect:/home";
	}

	@RequestMapping(value = "/education/{operation}/{id}", method = RequestMethod.GET)
	public String todoOperation(@PathVariable("operation") String operation, @PathVariable("id") int id, Model model) {

		logger.info("/education/operation: {} ", operation);

		if (operation.equals("edit")) {
			Education editEducation = educationService.findById(id);
			model.addAttribute("countryList", countryService.findAll());
			model.addAttribute("editEducation", editEducation);
			return "editEducation";

		} else if (operation.equals("delete")) {
			educationService.delete(id);

		}
		return "redirect:/home";

	}

	@RequestMapping("/jobOffer")
	public String jobOffer(Model model) {
		model.addAttribute("countryList", countryService.findAll());
		JobOffer jobOffer = new JobOffer();
		jobOffer.setIdRecruiter(globalController.getLoginUser().getId());
		model.addAttribute("reqJobOffer", jobOffer);
		logger.info("education");
		return "jobOffer";
	}

	@RequestMapping(value = { "/jobOffer/save" }, method = RequestMethod.POST)
	public String saveJobOffer(@ModelAttribute("reqJobOffer") JobOffer reqJobOffer,
			final RedirectAttributes redirectAttributes) {
		logger.info("/jobOffer/save");
		reqJobOffer.setCreationDate(new Timestamp(System.currentTimeMillis()));
		jobOfferService.save(reqJobOffer);
		return "redirect:/recruiter";
	}

	@RequestMapping(value = "/jobOffer/{operation}/{id}", method = RequestMethod.GET)
	public String manageJobOffer(@PathVariable("operation") String operation, @PathVariable("id") int id, Model model) {

		logger.info("/jobOffer/operation: {} ", operation);

		if (operation.equals("edit")) {
			JobOffer editJobOffer = jobOfferService.findById(id);
			model.addAttribute("countryList", countryService.findAll());
			model.addAttribute("editJobOffer", editJobOffer);
			return "editJobOffer";

		} else if (operation.equals("delete")) {
			jobOfferService.delete(id);

		}
		return "redirect:/recruiter";

	}

	@RequestMapping("/offers")
	public String offers(Model model) {
		logger.info("offers");
		model.addAttribute("listOffers", jobOfferService.findAll());
		return "offers";
	}

	@RequestMapping(value = "/detailOffer/{id}", method = RequestMethod.GET)
	public String detailsOffer(Model model, @PathVariable("id") int id) {
		logger.info("detailOffer");

		model.addAttribute("offer", jobOfferService.findById(id));
		return "detailOffer";
	}

	@RequestMapping(value = "/registerOffer/{id}", method = RequestMethod.GET)
	public String registerOffer(@PathVariable("id") int id) {
		logger.info("registerOffer");
		Registration registration = new Registration();
		registration.setIdOffer(id);
		registration.setIdUser(globalController.getLoginUser().getId());
		registrationService.save(registration);

		return "redirect:/home";
	}

}
