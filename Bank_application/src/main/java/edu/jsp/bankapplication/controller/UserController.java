package edu.jsp.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.bankapplication.model.User;
import edu.jsp.bankapplication.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public User createUser(@RequestBody  User u) {
		return userService.createUser(u);
	}

	@GetMapping("/getbyname")
	public List<User> searchByName(@RequestParam String name) {
		return userService.searchByName(name);
	}
	@GetMapping("/getUserByid")
	public User getUserById(@RequestParam Long id) {
		return  userService.getUserById(id);
	}

	@GetMapping("/getAllUserDetails")
	public List<User> fetchAll(){
		return userService.fetchAll();
	}
	
	@DeleteMapping("/deleteUserByid")
	public String deleteUserByid(Long id) {
		return userService.deleteUserByid(id);
	}
	
	@PutMapping("/updateUser")
	public User UpdateUserById(User user, Long id) {
		return userService.UpdateUserById(user, id);
	}
	
	@PutMapping("/updateUserByValue")
	public User UpdateUserNameAndEmailAndPassWord(Long id,String name,String email,String password) {
		return userService.UpdateUserNameAndEmailAndPassWord(id, name, email, password);
	}
		
		
}
