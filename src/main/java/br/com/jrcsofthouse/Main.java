package br.com.jrcsofthouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.jrcsofthouse.config.FileStorageConfig;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageConfig.class
})
@EnableAutoConfiguration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		/*
		 * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		 * String result = bCryptPasswordEncoder.encode("admin123");
		 * System.out.println("===========================================");
		 * System.out.println("Senha do usuário administrador = " + result);
		 * System.out.println("===========================================");
		 */
	}
}
