package me.airini.auto_attendance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IOLogResponse {
	private final String date;
	private final String userName;
	private final String place;

	@Builder
	public IOLogResponse(String place, String userName, String date) {
		this.place = place;
		this.userName = userName;
		this.date = date;
	}


}
