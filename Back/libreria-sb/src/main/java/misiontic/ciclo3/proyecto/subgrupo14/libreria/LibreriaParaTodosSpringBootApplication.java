package misiontic.ciclo3.proyecto.subgrupo14.libreria;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Category;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.Libro;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.entity.User;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.CategoryRepository;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.model.repository.LibroRepository;
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
		private final CategoryRepository categoryRepository;
		private final LibroRepository libroRepository;

		@Override
		public void run(String... args) throws Exception {
			// loadUsers();
			// loadCategories();
			// loadLibros();
		}

		private void loadUsers() {
			userRepository.save(new User("admin", "admin123", "Administrator",
					"admin@libreria.com", true, true));
		}

		private void loadCategories() {

			categoryRepository.saveAll(Arrays.asList(
					new Category("Fantasia"),
					new Category("Academicos"),
					new Category("Historico"),
					new Category("Poesia")));
		}

		private void loadLibros() {

			libroRepository.deleteAll();

			var category = categoryRepository.findByName("Fantasia").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro("001", "harry potter y la piedra", "magos", "planeta",
							"https://static.wikia.nocookie.net/esharrypotter/images/9/9a/Harry_Potter_y_la_Piedra_Filosofal_Portada_Espa%C3%B1ol.PNG/revision/latest?cb=20151020165725",
							category)));
		}
	}

}
