package me.airini.auto_attendance.service;

import me.airini.auto_attendance.dbo.IOLog;
import me.airini.auto_attendance.dbo.Place;
import me.airini.auto_attendance.dbo.User;
import me.airini.auto_attendance.dto.IOLogResponse;
import me.airini.auto_attendance.dto.UserResponse;
import me.airini.auto_attendance.exception.IllegalSignalException;
import me.airini.auto_attendance.exception.IllegalUserIDException;
import me.airini.auto_attendance.repository.IOLogRepository;
import me.airini.auto_attendance.repository.PlaceRepository;
import me.airini.auto_attendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class IOService {
	private final IOLogRepository ioLogRepository;
	private final UserRepository userRepository;
	private final PlaceRepository placeRepository;

	@Autowired
	public IOService(IOLogRepository ioLogRepository, UserRepository userRepository, PlaceRepository placeRepository) {
		this.ioLogRepository = ioLogRepository;
		this.userRepository = userRepository;
		this.placeRepository = placeRepository;
	}

	public IOLogResponse userPlaceChange(int signal, int userID) {
		Place place = this.placeRepository.findById(signal).orElseThrow(() -> new IllegalSignalException(Integer.toString(signal)));
		User user = this.userRepository.findById(userID).orElseThrow(() -> new IllegalUserIDException(Integer.toString(userID)));

		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		this.ioLogRepository.save(IOLog.builder()
				.date(now)
				.place(place)
				.user(user)
				.build());

		return IOLogResponse.builder()
				.userName(user.getName())
				.date(now.toString())
				.place(place.getPlaceName())
				.build();
	}

	public Map<Integer, UserResponse> retrieveAllLogByPlaceAndDate(Place place, LocalDate date) {
		Map<Integer, UserResponse> userResponses = new HashMap<>();
		for (IOLog ioLog : this.ioLogRepository.findAllByPlaceAndDateBetween(place, date.atStartOfDay(), date.plusDays(1).atStartOfDay())) {
			User user = ioLog.getUser();
			UserResponse response = UserResponse.builder()
					.name(user.getName())
					.build();
			if (userResponses.containsKey(user.getId())) {
				userResponses.get(user.getId()).addStayPeriod(ioLog.getDate(), this.getChangedDateTime(user, ioLog.getId()));
			} else {
				response.addStayPeriod(ioLog.getDate(), this.getChangedDateTime(user, ioLog.getId()));
				userResponses.put(user.getId(), response);
			}
		}
		return userResponses;
	}

	private LocalDateTime getChangedDateTime(User user, int id) {
		return this.ioLogRepository.findFirstByUserAndIdGreaterThan(user, id);
	}
}
