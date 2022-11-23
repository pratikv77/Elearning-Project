package study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Decryption;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import study.entity.CoordinatorTable;
import study.services.CoordinatorServiceImpl;



@SpringBootApplication
public class ELearningApplication implements CommandLineRunner {
	
	@Autowired
	CoordinatorServiceImpl coordinatorServiceImpl;

	@Autowired
	BCryptPasswordEncoder bcry;
	public static void main(String[] args) {
		SpringApplication.run(ELearningApplication.class, args);
		
	
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		  CoordinatorTable coordinatorTable=new CoordinatorTable();
//		  coordinatorTable.setCoordinatorEmail("abc@gmail.com");
//		  coordinatorTable.setCoordinatorPassword("pass");
//		  coordinatorTable.setRole("ROLE_ADMIN");
//		  coordinatorServiceImpl.save(coordinatorTable);
		 
	}

}
