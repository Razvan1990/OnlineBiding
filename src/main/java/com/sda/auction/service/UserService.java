package com.sda.auction.service;

import com.sda.auction.dto.UserForm;
import com.sda.auction.model.User;
import java.util.Optional;

public interface UserService {

	void saveUser(UserForm userForm);

	User findByEmail(String email);

	String getAuthenticatedEmail();

    User getLoggedInUser();

    boolean isLoggedUserAdmin();
}
