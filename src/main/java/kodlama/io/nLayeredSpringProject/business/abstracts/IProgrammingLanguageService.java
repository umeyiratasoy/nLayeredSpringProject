package kodlama.io.nLayeredSpringProject.business.abstracts;

import java.util.List;

import kodlama.io.nLayeredSpringProject.entities.concretes.ProgrammingLanguage;

public interface IProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();
	
	ProgrammingLanguage getById(int id);
	
	void add(ProgrammingLanguage language);
	
	void delete(int id);
	
	boolean update(ProgrammingLanguage language);
}
