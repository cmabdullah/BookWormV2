package com.ml.coreweb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * BookWormV2
 * Created on 21/8/22 - Sunday
 * User Khan, C M Abdullah
 * Ref:
 */
@Data
@Entity
@NoArgsConstructor
public class User extends BaseEntity {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	@Column(name = "email", nullable = false, updatable = false)
	private String email;
	private String phone;
}
