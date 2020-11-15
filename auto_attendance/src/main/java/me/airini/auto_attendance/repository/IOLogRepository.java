package me.airini.auto_attendance.repository;

import me.airini.auto_attendance.dbo.IOLog;
import me.airini.auto_attendance.dbo.Place;
import me.airini.auto_attendance.dbo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IOLogRepository extends JpaRepository<IOLog, Integer> {
	List<IOLog> findAllByPlaceAndDateBetween(Place place, LocalDateTime startingDate, LocalDateTime endingDate);

	@Query("select min(date) from IOLog where id > :id and user = :user")
	LocalDateTime findFirstByUserAndIdGreaterThan(User user, int id);
}
