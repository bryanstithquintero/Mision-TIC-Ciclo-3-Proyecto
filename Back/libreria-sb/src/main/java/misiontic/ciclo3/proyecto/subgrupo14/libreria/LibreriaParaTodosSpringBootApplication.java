package misiontic.ciclo3.proyecto.subgrupo14.libreria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.User;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.UserRepository;

@SpringBootApplication
public class LibreriaParaTodosSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaParaTodosSpringBootApplication.class, args);
	}

	@Component

	@Data

	@AllArgsConstructor
	public static class Dataloader implements CommandLineRunner {

		private final UserRepository userRepository;

		@Override
		public void run(String... args) throws Exception {
			loadUsers();
		}

		private void loadUsers() {
			userRepository.save(new User("admin", "admin123", "Administrator",
					"admin@libreria.com", true, true));
		}
	}

}
