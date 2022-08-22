package com.ml.app.repository;

import com.ml.app.domain.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	Categories findByCategoryName(String productCategory);
}
