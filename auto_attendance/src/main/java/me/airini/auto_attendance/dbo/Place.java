package me.airini.auto_attendance.dbo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Place {
	@Id
	private int signalCode;
	private String placeName;

	@Builder
	public Place(int signalCode, String placeName) {
		this.signalCode = signalCode;
		this.placeName = placeName;
	}

	@Override
	public String toString() {
		return "Place{" +
				"signalCode=" + signalCode +
				", placeName='" + placeName + '\'' +
				'}';
	}
}
