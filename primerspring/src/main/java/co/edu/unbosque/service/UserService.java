package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import co.edu.unbosque.model.User;
import co.edu.unbosque.repository.UserRepository;
import co.edu.unbosque.util.AESUtil;

@Service
public class UserService implements CRUDOperation<User> {

	// inyeccion de dependencias
	@Autowired
	private UserRepository userRepo;

	public UserService() {
	}
	
	public String sacarPromedio(User user) {
		//String grade1 =user.getGrade1() ;
		//String grade2 = user.getGrade2();
		//String grade3 = user.getGrade3();
		
		String grade1 =AESUtil.decrypt(user.getGrade1()) ;
		String grade2 = AESUtil.decrypt(user.getGrade2());
		String grade3 = AESUtil.decrypt(user.getGrade3());
		
		double doble1 = Double.parseDouble(grade1);
		double doble2 = Double.parseDouble(grade2);
		double doble3 = Double.parseDouble(grade3);
		
		double doublepromedio = (doble1+doble2+doble3)/3;
		String promedio = String.valueOf(doublepromedio);
		promedio=AESUtil.encrypt(promedio);
		
		return promedio;
	}

	public int createEncrypted(String username, String grade1, String grade2, String grade3, String promedio) {

		User temporal = new User(AESUtil.encrypt(username), AESUtil.encrypt(grade1), AESUtil.encrypt(grade2),
				AESUtil.encrypt(grade3), AESUtil.encrypt(promedio));

		return create(temporal);
	}

	@Override
	public int create(User data) {

		if (findUsernameAlreadyTaken(data)) {
			return 1; // Ya existe el usuario
		} else {
			userRepo.save(data);
		}
		return 0;
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	public List<User> getAllDecrypted() {
		List<User> temporal = getAll();
		String username = "";
		String grade1 = "";
		String grade2 = "";
		String grade3 = "";
		String promedio = "";
		for (int i = 0; i < getAll().size(); i++) {
			username = AESUtil.decrypt(getAll().get(i).getName());
			grade1 = AESUtil.decrypt(getAll().get(i).getGrade1());
			grade2 = AESUtil.decrypt(getAll().get(i).getGrade2());
			grade3 = AESUtil.decrypt(getAll().get(i).getGrade3());
			promedio = AESUtil.decrypt(getAll().get(i).getPromedio());
			temporal.set(i, new User(username, grade1, grade2, grade3, promedio));
			// decrypted.get(i).setUsername(password);
		}

		return temporal;
	}

	public List<User> getAllDesencrypted() {
		return userRepo.findAll();
	}

	@Override
	public int deleteById(Long id) {
		Optional<User> found = userRepo.findById(id);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	/*
	 * public int upDateByIdEngrypted(Long id,String username, String grade1, String
	 * grade2, String grade3, String promedio) { User user = new
	 * User(AESUtil.encrypt(username), AESUtil.encrypt(grade1),
	 * AESUtil.encrypt(grade2), AESUtil.encrypt(grade3), AESUtil.encrypt(promedio));
	 * return upDateById(id,user);
	 * 
	 * }
	 * 
	 * @Override public int upDateById(Long id, User newData) { Optional<User> found
	 * = userRepo.findById(id); Optional<User> newfound =
	 * userRepo.findByUsername(newData.getUsername()); if (found.isPresent() &&
	 * !newfound.isPresent()) { User temp = found.get();
	 * temp.setUsername(newData.getUsername());
	 * temp.setPassword(newData.getPassword()); userRepo.save(temp); return 0; }
	 * else if (found.isPresent() && newfound.isPresent()) { return 1; // no lo
	 * puede actualizar porque el nuevo ya existe } else if (!found.isPresent()) {
	 * return 2; // No existe lo que quiere actualizar } else { return 3; //
	 * cualquier otra eventualidad } }
	 */
	@Override
	public long count() {
		return userRepo.count();
	}

	@Override
	public boolean exists(Long id) {
		return userRepo.existsById(id) ? true : false;
	}

	public boolean findUsernameAlreadyTaken(User newUser) {

		Optional<User> found = userRepo.findByName(newUser.getName());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}

		// return false;
	}



}
