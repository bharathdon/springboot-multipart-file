package com.abc.template.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abc.template.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Service
public class UserService {
	@SneakyThrows
	public User getJson(String user, List<MultipartFile> file) {
		User user2 = new User();

		ObjectMapper objectMapper = new ObjectMapper();
		user2 = objectMapper.readValue(user, User.class);

		int size = file.size();
		user2.setCount(size);

		String multipartFile, type = null;
		String multipartFile1 = "";
		for (int i = 0; i < file.size(); i++) {

			multipartFile = file.iterator().next().getOriginalFilename().concat(",");

			multipartFile1 = multipartFile1 + multipartFile;

			type = file.iterator().next().getContentType();
			System.out.println(type);

		}

		String[] strings = multipartFile1.split(",");
		System.out.println(type);

		user2.setFileNames(Arrays.asList(strings));
		user2.setContent1(type);
		return user2;

	}
}
