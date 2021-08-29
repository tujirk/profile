package tujiorg.profile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tujiorg.profile.db.entities.User;
import tujiorg.profile.db.services.AwardsService;
import tujiorg.profile.db.services.DetailsServices;
import tujiorg.profile.db.services.ProjectsCoService;
import tujiorg.profile.db.services.ProjectsHoService;
import tujiorg.profile.db.services.UserService;

@Controller
public class ProfileInvitation {
	@Autowired
	private AwardsService awardsService;
	@Autowired
	private ProjectsCoService projectsCoService;
	@Autowired
	private ProjectsHoService projectsHoService;
	@Autowired
	private  UserService userServices; 
	@Autowired
	private DetailsServices detailsServices;
	
	@GetMapping({"/{pageVal}", "/"})
	public ModelAndView showProfile(@PathVariable(name="pageVal", required=false) String pageVal) {
		ModelAndView model= new ModelAndView("jsp/profile/home");
		if(pageVal!=null) {
			switch(pageVal.toUpperCase()) {
				case "PRJ-HOBBY" : 
					pageVal="1";
					model.addObject("ProjectsHo",projectsHoService.getActiveProjects());
					break;
				case "PRJ-CO" :
					pageVal="2"; 
					model.addObject("ProjectsCo", projectsCoService.getActiveProjects());
					break;
				case "ACHIVES" :
					pageVal="3"; 
					model.addObject("Awards", awardsService.getActiveAwards());
					break;
				case "QUALIFY" :
					pageVal="4"; break;
				default : pageVal="0";
			}
		} else {
			pageVal="0";
		}
		model.addObject("pageVal", pageVal);
		return model;
	}
	
	@ResponseBody
	@GetMapping("/getResume")
	public ResponseEntity<Resource> getResume() {
		Resource file=null;
		try {
			file= new UrlResource(detailsServices.getValueOf("RESUME_URL"));
			//file= new UrlResource(urlResume);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
		.body(file);
	}
	
	
	@GetMapping("/login")
	public String loginUserGet(HttpServletRequest request) {
		return "html/profile/login";
	}
	
	@PostMapping("/register")
	public ModelAndView registerUser(User user) {
		String view="html/profile/login";
		String error=null;
		if(!user.getUserID().trim().isEmpty()) {
			if(!isUserExist(user.getUserID())) {
				userServices.saveUser(user);
				view="redirect:/profile";
			} else {
				error="1";
			}
		} else {
			error="0";
		}

		ModelAndView model= new ModelAndView(view);
		if(error!=null) model.addObject("error", error);
		return model;
	}
	
	@ResponseBody
	@PostMapping("/isUserExist")
	public boolean isUserExist(@RequestBody String userId) {
		return userServices.isUserExist(userId.substring(userId.indexOf('=')+1 ) );
	}
}
