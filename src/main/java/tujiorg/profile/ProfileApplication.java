package tujiorg.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
		/*
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		 encryptor.setPassword("");
		 encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
		 encryptor.setIvGenerator(new RandomIvGenerator());
		 */
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
