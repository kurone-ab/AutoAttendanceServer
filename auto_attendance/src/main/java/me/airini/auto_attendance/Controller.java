package me.airini.auto_attendance;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
	@PostMapping("return")
	public String controller(@RequestParam(name = "value") String value) {
		return value;
	}
}
