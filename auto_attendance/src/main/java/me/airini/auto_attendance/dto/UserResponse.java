package me.airini.auto_attendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Getter
@Setter
public class UserResponse {
	private int id;
	private int placeID;
	private String name;
	private List<StayPeriod> stayPeriodList;

	@Builder
	public UserResponse(int id, int placeID, String name) {
		this.id = id;
		this.placeID = placeID;
		this.name = name;
		this.stayPeriodList = new ArrayList<>();
	}

	public void addStayPeriod(LocalDateTime startTime, LocalDateTime endTime) {
		stayPeriodList.add(StayPeriod.builder().startTime(startTime).endTime(endTime).build());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserResponse)) return false;

		UserResponse that = (UserResponse) o;

		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Builder
	@Getter
	public static class StayPeriod {
		private final LocalDateTime startTime, endTime;
	}
}
