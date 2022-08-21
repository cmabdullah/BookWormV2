package com.ml.coreweb.repository;

import com.ml.coreweb.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
