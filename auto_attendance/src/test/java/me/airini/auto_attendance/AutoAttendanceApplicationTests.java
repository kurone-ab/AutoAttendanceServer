package me.airini.auto_attendance;

import me.airini.auto_attendance.dbo.User;
import me.airini.auto_attendance.repository.IOLogRepository;
import me.airini.auto_attendance.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class AutoAttendanceApplicationTests {
	private IOLogRepository ioLogRepository;
	private PlaceService placeService;

	@Autowired
	public AutoAttendanceApplicationTests(IOLogRepository ioLogRepository, PlaceService placeService) {
		this.ioLogRepository = ioLogRepository;
		this.placeService = placeService;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void queryTest() {
		User user = new User();
		user.setId(1);
		user.setName("박성제");
		System.out.println(this.ioLogRepository.findFirstByUserAndIdGreaterThan(user, 77));
	}
}
