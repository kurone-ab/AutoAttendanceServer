package me.airini.auto_attendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Getter
@Setter
public class PlaceResponse {
	private int placeID;
	private String placeName;
	private Map<Integer, UserResponse> users;

	@Builder
	public PlaceResponse(int placeID, String placeName, Map<Integer, UserResponse> users) {
		this.placeID = placeID;
		this.placeName = placeName;
		this.users = users;
	}

	@Override
	public String toString() {
		return "PlaceResponse{" +
				"placeID=" + placeID +
				", placeName='" + placeName + '\'' +
				", users=" + users +
				'}';
	}
}
