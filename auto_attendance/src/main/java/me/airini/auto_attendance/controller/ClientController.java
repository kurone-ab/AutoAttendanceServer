package me.airini.auto_attendance.controller;

import me.airini.auto_attendance.dto.IOLogResponse;
import me.airini.auto_attendance.service.IOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true")
public class ClientController {
	private final IOService ioService;

	@Autowired
	public ClientController(IOService ioService) {
		this.ioService = ioService;
	}

	@PostMapping("/change")
	public ResponseEntity<IOLogResponse> userPlaceChange(@RequestParam(name = "signal") String signal, @RequestParam(name = "userID") String userID) {
		return ResponseEntity.ok(this.ioService.userPlaceChange(Integer.parseInt(signal), Integer.parseInt(userID)));
	}
}
