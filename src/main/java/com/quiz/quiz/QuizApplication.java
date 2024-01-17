package com.quiz.quiz;

import com.quiz.quiz.models.User;
import com.quiz.quiz.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public QuizApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// list all users from db
		for (User user: userRepository.findAll()){
			System.out.println(user.toString());
		}
	}
}













