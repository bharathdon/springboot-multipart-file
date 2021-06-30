package com.abc.template.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.template.model.User;
import com.abc.template.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/upload", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<User> upload(@RequestPart("user") String user,
			@RequestPart("file") List<MultipartFile> file) {

		User user2 = userService.getJson(user, file);

		return new ResponseEntity<User>(user2, HttpStatus.OK);

	}

}
