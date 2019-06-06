package com.zhiyou100.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nsfw")
public class NsfwController {

	@RequestMapping("/frame")
	public String frame() {
		return "nsfw/frame";
	}
	
	@RequestMapping("/home_top")
	public String home_top() {
		return "nsfw/top";
	}
	
	@RequestMapping("/home_left")
	public String home_left() {
		return "nsfw/left";
	}
}
