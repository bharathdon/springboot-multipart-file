package com.abc.template.model;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private String firstName;
	private String lastName;
	private Integer age;
	private String place;
	private Integer count;
	@Column(name = "file_names")
	private List<String> fileNames;

	private byte[] content1;
}
