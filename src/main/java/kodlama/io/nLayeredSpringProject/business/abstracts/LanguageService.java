package kodlama.io.nLayeredSpringProject.business.abstracts;

import java.util.List;

import kodlama.io.nLayeredSpringProject.business.dto.language.requests.AddLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.requests.UpdateLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetAllLanguageResponse;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();

	GetByIdLanguageResponse getById(int id);

	void add(AddLanguageRequest request);

	void update(int id, UpdateLanguageRequest request);

	void delete(int id);

}
