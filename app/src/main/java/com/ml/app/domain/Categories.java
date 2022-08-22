package com.ml.app.domain;

import lombok.*;

import javax.persistence.Entity;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@ToString
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categories extends BaseEntity {
	private String categoryName;
}
