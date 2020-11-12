package me.airini.auto_attendance.repository;

import me.airini.auto_attendance.dbo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select name from User where id = :id")
	User findNameById(int id);

	@Query("select name from User")
	List<String> findAllNames();
}
