package com.ml.app.repository;

import com.ml.app.domain.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookWormV2
 * Created on 22/8/22 - Monday
 * User Khan, C M Abdullah
 * Ref:
 */
public interface ShippingRepository extends JpaRepository<ShippingAddress, Long> {
}
