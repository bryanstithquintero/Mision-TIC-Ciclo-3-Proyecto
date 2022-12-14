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
							"Harry Potter se ha quedado hu??rfano y vive en casa de sus abominables t??os y el insoportable primo Dudley.",
							"planeta",
							"https://static.wikia.nocookie.net/esharrypotter/images/9/9a/Harry_Potter_y_la_Piedra_Filosofal_Portada_Espa%C3%B1ol.PNG",
							category),
					new Libro("002",
							"El hobbit",
							"se relata la historia de Bilbo Bols??n, su viaje a la Monta??a Solitaria junto con Gandalf y Thorin para recuperar el tesoro custodiado por un drag??n y recuperar tambi??n Erebor.",
							"minotauro",
							"https://www.planetadelibros.com.co/usuaris/libros/fotos/157/m_libros/156868_portada_el-hobbit-edicion-infantil_j-r-r-tolkien_201505211338.jpg",
							category),
					new Libro("003",
							"El nombre del viento",
							"cuenta la historia de Kvothe, un personaje legendario que, tras a??os de retiro, accede a contar los verdaderos motivos por los que se convirti?? en leyenda",
							"nova",
							"https://2.bp.blogspot.com/-XxLp5QL7jLA/WJuNjyyKBNI/AAAAAAAAFiU/4XfoTEenj4saPnD_BVn_OD7ll8NlaZgYwCLcB/s1600/nombre-del-viento-plaza-janes.jpg",
							category),
					new Libro("004",
							"El camino de los reyes",
							" Anhelo los d??as previos a la ??ltima Desolaci??n. El mundo fue nuestro, pero lo perdimos. ",
							"nova",
							"https://www.penguinlibros.com/co/1670482/el-camino-de-los-reyes-el-archivo-de-las-tormentas-1.jpg",
							category)));

			category = categoryRepository.findByName("Academicos").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"005",
							"Codigo limpio",
							"describe los principios, patrones y pr??cticas para crear c??digo limpio.",
							"anaya multimedia",
							"https://m.media-amazon.com/images/I/41K-wtoYjiL._AC_SY780_.jpg",
							category),
					new Libro(
							"006",
							"Cracking the Coding Interview",
							"Describe problemas t??picos de la inform??tica que suelen plantearse en las entrevistas de codificaci??n",
							"CarrerCup",
							"https://m.media-amazon.com/images/I/41oYsXjLvZL._AC_SY780_.jpg",
							category)));

			category = categoryRepository.findByName("Historico").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"007",
							"Biografia de la humanidad",
							"La especie humana es un h??brido de biolog??a y cultura, y este sorprendente y original libro le da todo el protagonismo no a la gen??tica, sino a la historia de la evoluci??n cultural",
							"Ariel",
							"https://images-na.ssl-images-amazon.com/images/I/81uuypDqSwL.jpg",
							category)));

			category = categoryRepository.findByName("Poesia").get();
			libroRepository.saveAll(Arrays.asList(
					new Libro(
							"008",
							"Ariel",
							"Esta obra es una brillante muestra del estilo po??tico de la gran escritora estadounidense, de versos alternativamente brutales y suaves",
							"hiperion",
							"https://i0.wp.com/www.hiperion.com/wp-content/uploads/2018/11/079-plath-ariel4.jpg",
							category),
					new Libro(
							"009",
							"Antologia poetica",
							" Una antolog??a personal con motivo del centenario del autor uruguayo,el poeta contempor??neo en espa??ol",
							"alianza",
							"https://panamericana.vteximg.com.br/arquivos/ids/372832-1080-1080/antologia-poetica-9789585118416.jpg",
							category)));
		}
	}

}
