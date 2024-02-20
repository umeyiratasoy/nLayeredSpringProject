package kodlama.io.nLayeredSpringProject.business.abstracts;

import java.util.List;

import kodlama.io.nLayeredSpringProject.business.dto.technology.requests.AddTechnologyRequest;
import kodlama.io.nLayeredSpringProject.business.dto.technology.requests.UpdateTechnologyRequest;
import kodlama.io.nLayeredSpringProject.business.dto.technology.responces.GetAllTechnologyResponse;
import kodlama.io.nLayeredSpringProject.business.dto.technology.responces.GetByIdTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();

	GetByIdTechnologyResponse getById(int id);

	void add(AddTechnologyRequest request);

	void update(int id, UpdateTechnologyRequest request);

	void delete(int id);
}