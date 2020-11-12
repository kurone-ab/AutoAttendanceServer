package me.airini.auto_attendance.service;

import me.airini.auto_attendance.dbo.IOLog;
import me.airini.auto_attendance.dbo.Place;
import me.airini.auto_attendance.dbo.User;
import me.airini.auto_attendance.dto.IOLogResponse;
import me.airini.auto_attendance.exception.IllegalSignalException;
import me.airini.auto_attendance.exception.IllegalUserIDException;
import me.airini.auto_attendance.repository.IOLogRepository;
import me.airini.auto_attendance.repository.PlaceRepository;
import me.airini.auto_attendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
		User testUser = this.userRepository.findNameById(user.getId());

		System.out.println(this.userRepository.findAllNames().toString());

		System.out.println(testUser.toString());

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
}
