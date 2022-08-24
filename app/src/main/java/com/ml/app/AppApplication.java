package com.ml.app;

import com.ml.app.domain.Categories;
import com.ml.app.service.CategoriesService;
import com.ml.auth.request.SignUpRequestDto;
import com.ml.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.ml.app", "com.ml.coreweb", "com.ml.auth"})
public class AppApplication implements CommandLineRunner {
	
	@Autowired
	CategoriesService categoriesService;
	
	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Categories> list = List.of(Categories.builder().categoryName("phone").build(),
		Categories.builder().categoryName("bike").build());
		categoriesService.saveAll(list);
		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		signUpRequestDto.setEmail("admin@gmail.com");
		signUpRequestDto.setPassword("1234");
		userService.saveAdmin(signUpRequestDto);
		log.info("admin saved "+ signUpRequestDto+ "username is admin@gmail.com and password is 1234");
	}
}
