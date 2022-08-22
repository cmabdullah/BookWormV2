package com.ml.app.repository;

import com.ml.app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByIdIn( List<Long> ids);
}
