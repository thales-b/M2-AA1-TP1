package fac.luminy.architecture.sample.project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@OpenAPIDefinition(
		info = @Info(
				title = "Sample Projet TP1",
				description = "Définition des endpoints disponible pour l'api pour BCM",
				version = "${info.app.version}"
		)
)
@SpringBootApplication
@EnableJpaAuditing
public class SampleProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleProjetApplication.class, args);
	}

}
