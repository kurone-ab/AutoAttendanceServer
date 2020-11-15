package me.airini.auto_attendance.controller;

import me.airini.auto_attendance.dto.PlaceResponse;
import me.airini.auto_attendance.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/place")
public class PlaceRetrieveController {
	private final PlaceService placeService;

	@Autowired
	public PlaceRetrieveController(PlaceService placeService) {
		this.placeService = placeService;
	}


	@GetMapping("/{id}/{date}")
	public PlaceResponse getPlace(@PathVariable int id, @PathVariable @DateTimeFormat(pattern = "yyyyMMdd") LocalDate date) {
		return this.placeService.retrievePlaceInfo(id, date);
	}

	@GetMapping("/list")
	public List<PlaceResponse> getPlaceList() {
		return this.placeService.getPlaces();
	}
}
