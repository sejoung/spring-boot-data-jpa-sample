/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.co.killers.sample.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WelComeController {

	@Value("${application.message}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model,Locale locale) {
		log.info("Welcome home! The client locale is {}.", locale);
		model.put("message", this.message);
		return "welcome";
	}
	
	
	@RequestMapping("/admin")
	public String admin(Map<String, Object> model,Locale locale) {
		log.info("Welcome home! The client locale is {}.", locale);
		return "admin";
	}
	
	@RequestMapping("/login")
	public String login(Map<String, Object> model,Locale locale) {
		log.info("Welcome home! The client locale is {}.", locale);
		return "login";
	}

}
