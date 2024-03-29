package me.airini.auto_attendance.repository;

import me.airini.auto_attendance.dbo.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
	List<Place> findAllByPlaceNameContains(String name);
}
