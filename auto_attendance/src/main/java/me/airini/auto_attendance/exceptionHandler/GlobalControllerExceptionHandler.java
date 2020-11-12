package me.airini.auto_attendance.exceptionHandler;

import me.airini.auto_attendance.dto.ResponseBody;
import me.airini.auto_attendance.exception.IllegalSignalException;
import me.airini.auto_attendance.exception.IllegalUserIDException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	@ExceptionHandler({ IllegalSignalException.class, IllegalUserIDException.class })
	public ResponseEntity<ResponseBody> handleBadRequest(RuntimeException e) {
		return ResponseEntity.badRequest().body(ResponseBody.builder()
				.date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd hh:mm:ss")))
				.message(e.getMessage())
				.build());
	}
}
