package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Demo;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping("/api")
public class TestController {

	private final DemoRepository demoRepository;

	public TestController(DemoRepository demoRepository) {
		super();
		this.demoRepository = demoRepository;
	}

	@GetMapping("/demo")
	public String demo() {

		List<Demo> data = demoRepository.findAll();
		if (data.isEmpty())
			return "Data not found.";
		else
			return "Hello Demo";
	}
}