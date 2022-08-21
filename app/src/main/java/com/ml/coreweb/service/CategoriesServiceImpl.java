package com.ml.coreweb.service;

import com.ml.coreweb.domain.Categories;
import com.ml.coreweb.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {
	
	private final CategoriesRepository categoriesRepository;
	
	@Autowired
	public CategoriesServiceImpl(CategoriesRepository categoriesRepository){
		this.categoriesRepository = categoriesRepository;
	}
	
	@Override
	public void saveAll(List<Categories> list) {
		categoriesRepository.saveAll(list);
	}
}
