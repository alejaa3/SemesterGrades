package co.edu.unbosque.configuration;

import java.util.Optional;

import co.edu.unbosque.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import co.edu.unbosque.repository.UserRepository;
import co.edu.unbosque.util.AESUtil;

@Configuration
public class LoadDataBase {

	private static final Logger LOG=LoggerFactory.getLogger(LoadDataBase.class);
	
	private CommandLineRunner initDataBase(UserRepository userRepo) {
		return args -> {
			Optional<User> found=userRepo.findByName("admin");
			if(found.isPresent()) {
				LOG.info("admin already exists, skipping admin creation");
			}else {
				userRepo.save(new User(AESUtil.encrypt("admin"), AESUtil.encrypt("0"),AESUtil.encrypt("0"),AESUtil.encrypt("0"),AESUtil.encrypt("0")));
				LOG.info("pre-loading admin-user");
			}
		};//landa
	}
		
	
	
}
