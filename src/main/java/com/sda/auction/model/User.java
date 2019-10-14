package com.sda.auction.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;

	@Column(name = "active")
	private int active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public void addRole(Role role) {
		if (roles == null) {
			roles = new HashSet<>();
		}
		this.roles.add(role);
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Item> items = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Bid> bids = new HashSet<>();
}

