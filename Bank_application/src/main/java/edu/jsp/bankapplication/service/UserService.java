package edu.jsp.bankapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.bankapplication.model.User;
import edu.jsp.bankapplication.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User u) {
		return userRepository.save(u);
	}

	public List<User> searchByName(String name) {
		return userRepository.getByname(name);
	}

	public User getUserById(Long id) {

		Optional<User> o = userRepository.findById(id);

		return o.isPresent() ? o.get() : null;

	}

	public String deleteUserByid(long userId) {

		User u = getUserById(userId);

		if (u != null) {
			userRepository.delete(u);
			return "data deletd";
		}

		return "id not found";
	}

	public List<User> fetchAll() {
		return userRepository.findAll();
	}

	public User UpdateUserById(User user, Long id) {
		User ExistingUser = getUserById(id);

		if (ExistingUser != null) {

			user.setId(id);
			userRepository.save(user);
			return user;

		}
		return null;

	}

	public User UpdateUserNameAndEmailAndPassWord(Long id, String name, String email, String password) {
		User user = getUserById(id);

		if (user != null) {
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);

			userRepository.save(user);

			return user;

		}
		return null;
	}

}
