package kodlama.io.nLayeredSpringProject.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.nLayeredSpringProject.business.abstracts.LanguageService;
import kodlama.io.nLayeredSpringProject.business.abstracts.TechnologyService;
import kodlama.io.nLayeredSpringProject.business.dto.language.requests.AddLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.requests.UpdateLanguageRequest;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetAllLanguageResponse;
import kodlama.io.nLayeredSpringProject.business.dto.language.responces.GetByIdLanguageResponse;
import kodlama.io.nLayeredSpringProject.business.dto.technology.requests.AddTechnologyRequest;
import kodlama.io.nLayeredSpringProject.business.dto.technology.requests.UpdateTechnologyRequest;
import kodlama.io.nLayeredSpringProject.business.dto.technology.responces.GetAllTechnologyResponse;
import kodlama.io.nLayeredSpringProject.business.dto.technology.responces.GetByIdTechnologyResponse;
import kodlama.io.nLayeredSpringProject.core.utilities.mapper.ModelMapperService;
import kodlama.io.nLayeredSpringProject.dataAccess.abstracts.ILanguageDao;
import kodlama.io.nLayeredSpringProject.dataAccess.abstracts.ITechnologyDao;
import kodlama.io.nLayeredSpringProject.entities.concretes.Language;
import kodlama.io.nLayeredSpringProject.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	@Autowired
	private ITechnologyDao technologyDao;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyDao.findAll();
		List<GetAllTechnologyResponse> technologyResponse = technologies.stream().map(
				technology -> this.modelMapperService.forResponse().map(technology, GetAllTechnologyResponse.class))
				.toList();
		return technologyResponse;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		GetByIdTechnologyResponse technologyResponse = this.modelMapperService.forResponse().map(technology,
				GetByIdTechnologyResponse.class);
		return technologyResponse;
	}

	@Override
	public void add(AddTechnologyRequest request) {
		Technology technology = this.modelMapperService.forRequest().map(request, Technology.class);
		this.technologyDao.save(technology);

	}

	@Override
	public void update(int id, UpdateTechnologyRequest request) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(request, technology);
		this.technologyDao.save(technology);

	}

	@Override
	public void delete(int id) {
		Technology technology = technologyDao.findById(id).orElseThrow();
		this.technologyDao.delete(technology);

	}

}
