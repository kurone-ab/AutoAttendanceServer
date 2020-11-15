package me.airini.auto_attendance.service;

import me.airini.auto_attendance.dbo.Place;
import me.airini.auto_attendance.dto.PlaceResponse;
import me.airini.auto_attendance.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
	private final PlaceRepository placeRepository;
	private final IOService ioService;

	@Autowired
	public PlaceService(PlaceRepository placeRepository, IOService ioService) {
		this.placeRepository = placeRepository;
		this.ioService = ioService;
	}

	public List<PlaceResponse> getPlaces() {
		List<PlaceResponse> places = new ArrayList<>();
		for (Place place : this.placeRepository.findAll()) {
			places.add(PlaceResponse.builder()
					.placeID(place.getSignalCode())
					.placeName(place.getPlaceName())
					.build());
		}
		return places;
	}

	public PlaceResponse retrievePlaceInfo(int id, LocalDate date) {
		Place place = this.placeRepository.findById(id).get();
		return getPlaceResponse(place, date);
	}

	private PlaceResponse getPlaceResponse(Place place, LocalDate date) {
		return PlaceResponse.builder()
				.placeID(place.getSignalCode())
				.users(this.ioService.retrieveAllLogByPlaceAndDate(place, date))
				.build();
	}

}
