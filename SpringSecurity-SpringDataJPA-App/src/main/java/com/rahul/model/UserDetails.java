package com.rahul.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SECURITY_USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;

	@Column(length = 20, unique = true, nullable = false)
	private String uname;

	@Column(length = 250, unique = true, nullable = false)
	private String pwd;

	@Column(length = 20, unique = true, nullable = false)
	private String mail;

	private boolean status = true;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "SECURITY_ROLES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "uid"))
	@Column(name = "role")
	private Set<String> roles;

}
