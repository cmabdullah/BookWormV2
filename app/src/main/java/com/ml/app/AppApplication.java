package com.ml.app;

import com.ml.app.domain.Categories;
import com.ml.app.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ml.app", "com.ml.coreweb", "com.ml.auth", "com.ml.email"})
public class AppApplication implements CommandLineRunner {
	
	@Autowired
	CategoriesService categoriesService;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Categories> list = List.of(Categories.builder().categoryName("phone").build(),
		Categories.builder().categoryName("bike").build());
		categoriesService.saveAll(list);
	}
}
