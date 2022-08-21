package com.ml.coreweb;

import com.ml.coreweb.domain.Categories;
import com.ml.coreweb.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
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
