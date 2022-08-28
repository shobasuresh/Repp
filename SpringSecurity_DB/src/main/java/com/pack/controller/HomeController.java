package com.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class HomeController {

	 

		@GetMapping("/admin")
		public String admin() {
			return "adminPage";
		}

		@GetMapping("/user")
		public String user() {
			return "userPage";
		}

		@GetMapping("/all")
		public String all() {
			return "allPage";
		}
	}