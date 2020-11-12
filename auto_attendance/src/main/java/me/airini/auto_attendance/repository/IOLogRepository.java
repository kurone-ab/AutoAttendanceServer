package me.airini.auto_attendance.repository;

import me.airini.auto_attendance.dbo.IOLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOLogRepository extends JpaRepository<IOLog, Integer> {
}
