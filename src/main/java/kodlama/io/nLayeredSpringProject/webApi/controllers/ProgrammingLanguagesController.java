package kodlama.io.nLayeredSpringProject.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.nLayeredSpringProject.business.abstracts.IProgrammingLanguageService;
import kodlama.io.nLayeredSpringProject.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private IProgrammingLanguageService programmingLanguageService;
	
	@Autowired // default otomatik yani IoC yapılandırması vardır spring bootta
	public ProgrammingLanguagesController(IProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getAll")
	public List<ProgrammingLanguage> getAll(){
		
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id){
		
		return programmingLanguageService.getById(id);
	}
	
	@PostMapping("/delete")
	public void delete(int id) {
		programmingLanguageService.delete(id);
	}
	
    @PostMapping("/add")
    public void add (ProgrammingLanguage language) {
    	programmingLanguageService.add(language);
    }
    
    @PostMapping("/update")
    public boolean update(ProgrammingLanguage language) {
    	programmingLanguageService.update(language);
    	return true;
    }
}
