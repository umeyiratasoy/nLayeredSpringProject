package kodlama.io.nLayeredSpringProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NLayeredSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NLayeredSpringProjectApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
