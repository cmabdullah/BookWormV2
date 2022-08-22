package com.ml.app.repository;

import com.ml.app.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
