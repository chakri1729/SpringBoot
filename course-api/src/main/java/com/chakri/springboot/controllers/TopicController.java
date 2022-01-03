package com.chakri.springboot.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chakri.springboot.models.Topic;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("spring","spring framework", "spring framework description"),
				new Topic("spring cloud","spring framework", "Micro Services")
				);
	}
}
