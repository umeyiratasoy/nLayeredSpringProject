package kodlama.io.nLayeredSpringProject.business.dto.technology.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
	private int id;
	private String name;
	private int languageId;
	private String languageName;
}