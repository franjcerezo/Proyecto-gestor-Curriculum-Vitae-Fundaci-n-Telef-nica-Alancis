package com.selectcv.controller;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.selectcv.model.User;
import com.selectcv.service.EducationService;
import com.selectcv.service.ExperienceService;
import com.selectcv.service.JobOfferService;
import com.selectcv.service.UserService;
import com.selectcv.utils.PassEncoding;
import com.selectcv.utils.Roles;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	GlobalController globalController;

	@Autowired
	UserService userService;

	@Autowired
	private EducationService educationService;

	@Autowired
	ExperienceService experienceService;

	@Autowired
	private JobOfferService jobOfferService;

	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("reqUser", new User());
		logger.info("root");
		return "login";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("reqUser", new User());
		logger.info("login");
		return "login";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("educationList", educationService.findByUser(globalController.getLoginUser()));
		model.addAttribute("experienceList", experienceService.findByUser(globalController.getLoginUser()));
		logger.info("home");
		return "home";
	}

	@RequestMapping("/admin")
	public String helloAdmin() {
		logger.info("admin");
		return "admin";
	}

	@RequestMapping("/recruiter")
	public String helloRecruiter(Model model) {
		model.addAttribute("jobOfferList", jobOfferService.findByIdRecruiter(globalController.getLoginUser().getId()));
		logger.info("recruiter");
		return "recruiter";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("reqUser", new User());
		logger.info("register");
		return "register";
	}

	@RequestMapping(value = { "/user/register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("reqUser") User reqUser, final RedirectAttributes redirectAttributes) {

		logger.info("/user/register");
		User user = userService.findByUserName(reqUser.getUsername());
		if (user != null) {
			redirectAttributes.addFlashAttribute("saveUser", "exist-name");
			return "redirect:/register";
		}
		user = userService.findByEmail(reqUser.getEmail());
		if (user != null) {
			redirectAttributes.addFlashAttribute("saveUser", "exist-email");
			return "redirect:/register";
		}

		reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
		reqUser.setRole(Roles.ROLE_CANDIDATE.getValue());
		reqUser.setCreationDate(new Timestamp(System.currentTimeMillis()));

		if (userService.save(reqUser) != null) {
			redirectAttributes.addFlashAttribute("saveUser", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveUser", "fail");
		}

		return "redirect:/register";
	}

	@RequestMapping("/registerRecruiter")
	public String registerRecruiter(Model model) {
		model.addAttribute("reqUser", new User());
		logger.info("registerRecruiter");
		return "registerRecruiter";
	}

	@RequestMapping(value = { "/user/registerRecruiter" }, method = RequestMethod.POST)
	public String registerRecruiter(@ModelAttribute("reqUser") User reqUser,
			final RedirectAttributes redirectAttributes) {

		logger.info("/user/registerRecruiter");
		User user = userService.findByUserName(reqUser.getUsername());
		if (user != null) {
			redirectAttributes.addFlashAttribute("saveUser", "exist-name");
			return "redirect:/registerRecruiter";
		}
		user = userService.findByEmail(reqUser.getEmail());
		if (user != null) {
			redirectAttributes.addFlashAttribute("saveUser", "exist-email");
			return "redirect:/registerRecruiter";
		}

		reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
		reqUser.setRole(Roles.ROLE_RECRUITER.getValue());
		reqUser.setCreationDate(new Timestamp(System.currentTimeMillis()));

		if (userService.save(reqUser) != null) {
			redirectAttributes.addFlashAttribute("saveUser", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveUser", "fail");
		}

		return "redirect:/registerRecruiter";
	}

}
