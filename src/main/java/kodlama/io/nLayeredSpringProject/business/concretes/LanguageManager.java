package kodlama.io.nLayeredSpringProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.nLayeredSpringProject.business.abstracts.LanguageService;
import kodlama.io.nLayeredSpringProject.business.dto.language.requests.AddLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.requests.UpdateLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetAllLanguageResponse;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetByIdLanguageResponse;
import kodlama.io.nLayeredSpringProject.core.utilities.mapper.ModelMapperService;
import kodlama.io.nLayeredSpringProject.dataAccess.abstracts.ILanguageDao;
import kodlama.io.nLayeredSpringProject.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	@Autowired
	private ILanguageDao languageDao;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageDao.findAll();
		List<GetAllLanguageResponse> languageResponse = languages.stream()
				.map(language -> this.modelMapperService.forResponse().map(language, GetAllLanguageResponse.class))
				.toList();
		return languageResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		GetByIdLanguageResponse languageResponse = this.modelMapperService.forResponse().map(language,
				GetByIdLanguageResponse.class);
		return languageResponse;
	}

	@Override
	public void add(AddLanguageRequest request) {
		Language language = this.modelMapperService.forRequest().map(request, Language.class);
		this.languageDao.save(language);
	}

	@Override
	public void update(int id, UpdateLanguageRequest request) {
		Language language = languageDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(request, language);
		this.languageDao.save(language);
	}

	@Override
	public void delete(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		this.languageDao.delete(language);

	}
}
