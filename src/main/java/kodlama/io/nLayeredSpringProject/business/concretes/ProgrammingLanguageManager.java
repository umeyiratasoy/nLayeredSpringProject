package kodlama.io.nLayeredSpringProject.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.nLayeredSpringProject.business.abstracts.IProgrammingLanguageService;
import kodlama.io.nLayeredSpringProject.dataAccess.abstracts.IProgrammingLanguageRepository;
import kodlama.io.nLayeredSpringProject.entities.concretes.ProgrammingLanguage;

@Service 
public class ProgrammingLanguageManager implements IProgrammingLanguageService {

	private IProgrammingLanguageRepository programmingLanguageRepository;
	
	
	
	@Autowired
	public ProgrammingLanguageManager(IProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage language) {
		if (language.getName() == null  || language.getName() == "") {
			System.out.println("Dil boş geçilemez");
		}
		
		List<ProgrammingLanguage> programmingLanguages = getAll();
		for (ProgrammingLanguage pL : programmingLanguages) {
			if (pL.getName() == language.getName()) {
				System.out.println(language.getName() + " için isimler tekrar edilemez.");
			}
		}
		programmingLanguageRepository.add(language);
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public boolean update(ProgrammingLanguage language) {
		if (language.getName() == null  || language.getName() == "") {
			System.out.println("Dil boş geçilemez");
		}
		return programmingLanguageRepository.update(language);
	}
	
}
