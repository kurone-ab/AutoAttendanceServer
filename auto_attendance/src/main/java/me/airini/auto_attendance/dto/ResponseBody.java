package me.airini.auto_attendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseBody {
	protected String message;
	protected String date;

	@Builder
	public ResponseBody(String message, String date) {
		this.message = message;
		this.date = date;
	}
}
