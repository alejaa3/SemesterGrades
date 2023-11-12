package co.edu.unbosque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.model.User;
import co.edu.unbosque.service.UserService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" }) // asterisco solo para desarrollo
@Transactional // operaciones crud en masa
public class UserController {

	@Autowired
	private UserService userServ;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	

	@GetMapping(path = "/saludar")
	public ResponseEntity<String> saludar() {
		return new ResponseEntity<String>("Buenos dias mundo", HttpStatus.OK);
	}

	@PostMapping(path = "/createuserjson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNewUserJson(@RequestBody User newUser) {
		System.out.println(8493947);
		int status = userServ.createEncrypted(newUser.getName(), newUser.getGrade1(), newUser.getGrade2(),
				newUser.getGrade3(), userServ.sacarPromedio(newUser));
		if (status == 0) {
			return new ResponseEntity<String>("Usuario creado con exito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Usuario ya existente", HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@GetMapping(path = "/getall")
	public ResponseEntity<List<User>> getAllDecrypted() {
		List<User> users = userServ.getAllDecrypted();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(users, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		int status = userServ.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<String>("Eliminado exitosamente", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Error al eliminar usuario", HttpStatus.NOT_FOUND);
		}

	}

}
