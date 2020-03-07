package kma.niko.practice6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Practice6Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Practice6Application.class, args);
		UserService userService = applicationContext.getBean(UserService.class);

		UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
		System.out.println("Saved new user: " + user);
		userService.createUser("alan", "smith", "email2@example.com");
		userService.createUser("cecilia", "smith", "email3@example.com");
		userService.createUser("elton", "john", "email4@example.com");

		System.out.printf("=====FIND ALL=====");
		List<UserEntity> users = userService.findAllUsers();
		for(UserEntity u : users)
			System.out.println(u);
		System.out.printf("=====FIND ALL SMITHS====");
		users = userService.findByLastName("Smith");
		for(UserEntity u : users)
			System.out.println(u);
		System.out.printf("====FIND ALL WHOSE NAMES CONTAIN 'A'=======");
		users = userService.findUserWhereFirstOrLastNameContains("a");
		for(UserEntity u : users)
			System.out.println(u);

	}

}
