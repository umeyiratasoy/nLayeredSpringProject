package kodlama.io.nLayeredSpringProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.nLayeredSpringProject.dataAccess.abstracts.IProgrammingLanguageRepository;
import kodlama.io.nLayeredSpringProject.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements IProgrammingLanguageRepository {
	
	List<ProgrammingLanguage> programmingLanguages;
	
	
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"Python"));
		programmingLanguages.add(new ProgrammingLanguage(3,"Java"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Kotlin"));
		programmingLanguages.add(new ProgrammingLanguage(5,"C++"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

	@Override
	public void add(ProgrammingLanguage language) {
		programmingLanguages.add(language);
		
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage toRemoveProgrammingLanguage = getById(id);
        if (toRemoveProgrammingLanguage != null) {
        	programmingLanguages.remove(toRemoveProgrammingLanguage);
        }
	}

	@Override
	public boolean  update(ProgrammingLanguage language) {
		for (ProgrammingLanguage pl : programmingLanguages) {
			if (pl.getId() == language.getId()) {
				programmingLanguages.remove(pl);
				programmingLanguages.add(language);
				return true;
			}
		}
		return false;
		
	}

}
