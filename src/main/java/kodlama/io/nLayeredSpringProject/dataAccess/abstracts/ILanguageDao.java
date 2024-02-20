package kodlama.io.nLayeredSpringProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.nLayeredSpringProject.entities.concretes.Language;

public interface ILanguageDao extends  JpaRepository<Language,Integer> {
	
}
