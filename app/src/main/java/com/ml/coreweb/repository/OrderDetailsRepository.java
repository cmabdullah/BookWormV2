package com.ml.coreweb.repository;

import com.ml.coreweb.domain.Categories;
import com.ml.coreweb.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
