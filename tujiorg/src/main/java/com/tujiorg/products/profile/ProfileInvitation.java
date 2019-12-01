package com.tujiorg.products.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tujiorg.products.profile.db.entities.Awards;
import com.tujiorg.products.profile.db.entities.ProjectsCo;
import com.tujiorg.products.profile.db.services.AwardsService;
import com.tujiorg.products.profile.db.services.ProjectsCoService;
import com.tujiorg.products.profile.db.services.ProjectsHoService;

@Controller
public class ProfileInvitation {
	@Autowired
	private AwardsService awardsService;
	
	@Autowired
	private ProjectsCoService projectsCoService;
	
	@Autowired
	private ProjectsHoService projectsHoService;
	
	@Value("${url.resume}")
	private String resumeUrl;
	
	@GetMapping({"/profile/{pageVal}", "/profile"})
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
					Awards award=awardsService.getAwardById(1);
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
			file= new UrlResource(resumeUrl);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
		.body(file);
	}
}
