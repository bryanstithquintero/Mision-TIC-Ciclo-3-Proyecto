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
					new Libro("001",
							"harry potter y la piedra filosofal",
							"Harry Potter se ha quedado huérfano y vive en casa de sus abominables tíos y el insoportable primo Dudley.",
							"planeta",
							"https://static.wikia.nocookie.net/esharrypotter/images/9/9a/Harry_Potter_y_la_Piedra_Filosofal_Portada_Espa%C3%B1ol.PNG",
							category),
					new Libro("002",
							"El hobbit",
							"se relata la historia de Bilbo Bolsón, su viaje a la Montaña Solitaria junto con Gandalf y Thorin para recuperar el tesoro custodiado por un dragón y recuperar también Erebor.",
							"minotauro",
							"https://www.planetadelibros.com.co/usuaris/libros/fotos/157/m_libros/156868_portada_el-hobbit-edicion-infantil_j-r-r-tolkien_201505211338.jpg",
							category),
					new Libro("003",
							"El nombre del viento",
							"cuenta la historia de Kvothe, un personaje legendario que, tras años de retiro, accede a contar los verdaderos motivos por los que se convirtió en leyenda",
							"nova",
							"https://2.bp.blogspot.com/-XxLp5QL7jLA/WJuNjyyKBNI/AAAAAAAAFiU/4XfoTEenj4saPnD_BVn_OD7ll8NlaZgYwCLcB/s1600/nombre-del-viento-plaza-janes.jpg",
							category),
					new Libro("004",
							"El camino de los reyes",
							" Anhelo los días previos a la Última Desolación. El mundo fue nuestro, pero lo perdimos. ",
							"nova",
							"https://www.penguinlibros.com/co/1670482/el-camino-de-los-reyes-el-archivo-de-las-tormentas-1.jpg",
							category)));

			category = categoryRepository.findByName("Academicos").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"005",
							"Codigo limpio",
							"describe los principios, patrones y prácticas para crear código limpio.",
							"anaya multimedia",
							"https://m.media-amazon.com/images/I/41K-wtoYjiL._AC_SY780_.jpg",
							category),
					new Libro(
							"006",
							"Cracking the Coding Interview",
							"Describe problemas típicos de la informática que suelen plantearse en las entrevistas de codificación",
							"CarrerCup",
							"https://m.media-amazon.com/images/I/41oYsXjLvZL._AC_SY780_.jpg",
							category)));

			category = categoryRepository.findByName("Historico").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"007",
							"Biografia de la humanidad",
							"La especie humana es un híbrido de biología y cultura, y este sorprendente y original libro le da todo el protagonismo no a la genética, sino a la historia de la evolución cultural",
							"Ariel",
							"https://images-na.ssl-images-amazon.com/images/I/81uuypDqSwL.jpg",
							category)));

			category = categoryRepository.findByName("Poesia").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"008",
							"Ariel",
							"Esta obra es una brillante muestra del estilo poético de la gran escritora estadounidense, de versos alternativamente brutales y suaves",
							"hiperion",
							"https://i0.wp.com/www.hiperion.com/wp-content/uploads/2018/11/079-plath-ariel4.jpg",
							category),
					new Libro(
							"009",
							"Antologia poetica",
							" Una antología personal con motivo del centenario del autor uruguayo,el poeta contemporáneo en español",
							"alianza",
							"https://panamericana.vteximg.com.br/arquivos/ids/372832-1080-1080/antologia-poetica-9789585118416.jpg",
							category)));
		}
	}

}
